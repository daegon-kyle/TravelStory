package manager;

import java.util.*;

import dao.BlogDAO;
import dao.CategoryDAO;
import dao.MainCategoryDAO;
import dao.SubCategoryDAO;
import dto.CategoryDTO;
import dto.MainCategoryDTO;



import model.CategoryInfo;

public class CategoryManager {
	private CategoryInfo categoryInfo;
	
	public CategoryManager(){
		this(new CategoryInfo());
	}
	public CategoryManager(CategoryInfo categoryInfo){
		this.categoryInfo=categoryInfo;
	}
	
	public boolean insert(String memberCode){
		MainCategoryDAO mainCategoryDAO=new MainCategoryDAO();
		if(mainCategoryDAO.insert(memberCode, categoryInfo.getCategoryName()))
			return true;
		else
			return false;
	}
	//하위폴더에 삽입!
	public boolean insert(String memberCode, String mainCategoryCode){
		SubCategoryDAO subCategoryDAO=new SubCategoryDAO();
		if(subCategoryDAO.insert(categoryInfo.getCategoryCode(), categoryInfo.getCategoryName()))
			return true;
		else
			return false;
	}
	public boolean deleteMainCategory(String memberCode){
		MainCategoryDAO mainCategoryDAO=new MainCategoryDAO();
		if(mainCategoryDAO.delete(categoryInfo.getCategoryCode()))
			return true;
		else
			return false;
	}
	public boolean deleteSubCategory(String memberCode){
		SubCategoryDAO subCategoryDAO=new SubCategoryDAO();
		if(subCategoryDAO.delete(categoryInfo.getCategoryCode()))
			return true;
		else
			return false;
	}
	public boolean reviseMainCategory(String memberCode){
		MainCategoryDAO mainCategoryDAO=new MainCategoryDAO();
		if( mainCategoryDAO.updateMainCategoryName(categoryInfo.getCategoryCode(), categoryInfo.getCategoryName()) )
			return true;
		else
			return false;
	}
	public boolean reviseSubCategory(String memberCode){
		SubCategoryDAO subCategoryDAO=new SubCategoryDAO();
		if(subCategoryDAO.updateSubCategoryName(categoryInfo.getCategoryCode(), categoryInfo.getCategoryName()))
			return true;
		else
			return false;
	}
	//2개의 DAO 건드리므로 DAO매니저 만들 필요있음
	public List<CategoryInfo> selectMainCategorys(String memberCode){
		BlogDAO blogDAO=new BlogDAO();
		String blogCode=blogDAO.selectBlogCode(memberCode);
		
		MainCategoryDAO mainCategoryDAO=new MainCategoryDAO();
		ArrayList<MainCategoryDTO> mainCategoryDTOList=(ArrayList<MainCategoryDTO>)mainCategoryDAO.selectMainCategorys(blogCode);
		ArrayList<CategoryInfo> categoryInfoList=new ArrayList<CategoryInfo>();
		System.out.println("for문!");
		
		
		for(MainCategoryDTO tmp: mainCategoryDTOList){
			CategoryInfo categoryInfo=new CategoryInfo();
			
			String mainCategoryCode=tmp.getMainCategoryCode();
			String mainCategoryName=tmp.getMainCategoryName();
			
			categoryInfo.setCategoryCode(mainCategoryCode);
			categoryInfo.setCategoryName(mainCategoryName);
			categoryInfo.setCategoryDepth(0);	//부모카테고리는 0
			
			categoryInfoList.add(categoryInfo);
			
			System.out.println(mainCategoryCode);
		}System.out.println("for문 끝");
		
		return categoryInfoList;
	}
	public List<CategoryInfo> selectSubCategorys(String memberCode){
		ArrayList<CategoryInfo> mainCategoryList=(ArrayList<CategoryInfo>)selectMainCategorys(memberCode);	//메인카테고리 가지고오기
		
		CategoryDAO categoryDAO=new CategoryDAO();
		ArrayList<CategoryInfo> categoryInfoList=new ArrayList<CategoryInfo>();	//반환할 한 멤버의 카테고리목록
		
		System.out.println("for문 시작");
				
		for(CategoryInfo tmp : mainCategoryList){
			ArrayList<CategoryDTO> tmpList=(ArrayList<CategoryDTO>)categoryDAO.selectSubCategorys(memberCode, tmp.getCategoryCode());	//subCategory가지고오기
			for(CategoryDTO DTOtmp:tmpList){
				CategoryInfo categoryInfo=new CategoryInfo();
				categoryInfo.setCategoryCode(DTOtmp.getSubCategoryCode());
				categoryInfo.setCategoryName(DTOtmp.getSubCategoryName());
				categoryInfo.setCategoryDepth(1);	//자식카테고리는 1
				categoryInfo.setParentCategoryCode(DTOtmp.getMainCategoryCode());
				
				categoryInfoList.add(categoryInfo);
				//메인카테고리를 이용해 가지고 온 서브카테고리를 리스트에 넣는다.
			}
		}
		System.out.println("for문 끝");
		return categoryInfoList; 
	}
	public List<CategoryInfo> selectCategorys(String memberCode){
		ArrayList<CategoryInfo> mainCategoryList=(ArrayList<CategoryInfo>)selectMainCategorys(memberCode);	//메인카테고리 가지고오기
		
		CategoryDAO categoryDAO=new CategoryDAO();
		ArrayList<CategoryInfo> categoryInfoList=new ArrayList<CategoryInfo>();	//반환할 한 멤버의 카테고리목록
		
		System.out.println("for문 시작");
		for(CategoryInfo tmp : mainCategoryList){
			categoryInfoList.add(tmp);
			//메인카테고리를 집어넣는다.
			ArrayList<CategoryDTO> tmpList=(ArrayList<CategoryDTO>)categoryDAO.selectSubCategorys(memberCode, tmp.getCategoryCode());	//subCategory가지고오기
			for(CategoryDTO DTOtmp:tmpList){
				CategoryInfo categoryInfo=new CategoryInfo();
				categoryInfo.setCategoryCode(DTOtmp.getSubCategoryCode());
				categoryInfo.setCategoryName(DTOtmp.getSubCategoryName());
				categoryInfo.setCategoryDepth(1);
				categoryInfo.setParentCategoryCode(DTOtmp.getMainCategoryCode());
				
				categoryInfoList.add(categoryInfo);
				//메인카테고리를 이용해 가지고 온 서브카테고리를 리스트에 넣는다.
			}
		}
		System.out.println("for문 끝");
		return categoryInfoList; 
	}
	
	public CategoryInfo getCategoryInfo() {
		return categoryInfo;
	}
	public void setCategoryInfo(CategoryInfo categoryInfo) {
		this.categoryInfo = categoryInfo;
	}
	
}
