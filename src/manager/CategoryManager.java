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
	//���������� ����!
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
	//2���� DAO �ǵ帮�Ƿ� DAO�Ŵ��� ���� �ʿ�����
	public List<CategoryInfo> selectMainCategorys(String memberCode){
		BlogDAO blogDAO=new BlogDAO();
		String blogCode=blogDAO.selectBlogCode(memberCode);
		
		MainCategoryDAO mainCategoryDAO=new MainCategoryDAO();
		ArrayList<MainCategoryDTO> mainCategoryDTOList=(ArrayList<MainCategoryDTO>)mainCategoryDAO.selectMainCategorys(blogCode);
		ArrayList<CategoryInfo> categoryInfoList=new ArrayList<CategoryInfo>();
		System.out.println("for��!");
		
		
		for(MainCategoryDTO tmp: mainCategoryDTOList){
			CategoryInfo categoryInfo=new CategoryInfo();
			
			String mainCategoryCode=tmp.getMainCategoryCode();
			String mainCategoryName=tmp.getMainCategoryName();
			
			categoryInfo.setCategoryCode(mainCategoryCode);
			categoryInfo.setCategoryName(mainCategoryName);
			categoryInfo.setCategoryDepth(0);	//�θ�ī�װ��� 0
			
			categoryInfoList.add(categoryInfo);
			
			System.out.println(mainCategoryCode);
		}System.out.println("for�� ��");
		
		return categoryInfoList;
	}
	public List<CategoryInfo> selectSubCategorys(String memberCode){
		ArrayList<CategoryInfo> mainCategoryList=(ArrayList<CategoryInfo>)selectMainCategorys(memberCode);	//����ī�װ� ���������
		
		CategoryDAO categoryDAO=new CategoryDAO();
		ArrayList<CategoryInfo> categoryInfoList=new ArrayList<CategoryInfo>();	//��ȯ�� �� ����� ī�װ����
		
		System.out.println("for�� ����");
				
		for(CategoryInfo tmp : mainCategoryList){
			ArrayList<CategoryDTO> tmpList=(ArrayList<CategoryDTO>)categoryDAO.selectSubCategorys(memberCode, tmp.getCategoryCode());	//subCategory���������
			for(CategoryDTO DTOtmp:tmpList){
				CategoryInfo categoryInfo=new CategoryInfo();
				categoryInfo.setCategoryCode(DTOtmp.getSubCategoryCode());
				categoryInfo.setCategoryName(DTOtmp.getSubCategoryName());
				categoryInfo.setCategoryDepth(1);	//�ڽ�ī�װ��� 1
				categoryInfo.setParentCategoryCode(DTOtmp.getMainCategoryCode());
				
				categoryInfoList.add(categoryInfo);
				//����ī�װ��� �̿��� ������ �� ����ī�װ��� ����Ʈ�� �ִ´�.
			}
		}
		System.out.println("for�� ��");
		return categoryInfoList; 
	}
	public List<CategoryInfo> selectCategorys(String memberCode){
		ArrayList<CategoryInfo> mainCategoryList=(ArrayList<CategoryInfo>)selectMainCategorys(memberCode);	//����ī�װ� ���������
		
		CategoryDAO categoryDAO=new CategoryDAO();
		ArrayList<CategoryInfo> categoryInfoList=new ArrayList<CategoryInfo>();	//��ȯ�� �� ����� ī�װ����
		
		System.out.println("for�� ����");
		for(CategoryInfo tmp : mainCategoryList){
			categoryInfoList.add(tmp);
			//����ī�װ��� ����ִ´�.
			ArrayList<CategoryDTO> tmpList=(ArrayList<CategoryDTO>)categoryDAO.selectSubCategorys(memberCode, tmp.getCategoryCode());	//subCategory���������
			for(CategoryDTO DTOtmp:tmpList){
				CategoryInfo categoryInfo=new CategoryInfo();
				categoryInfo.setCategoryCode(DTOtmp.getSubCategoryCode());
				categoryInfo.setCategoryName(DTOtmp.getSubCategoryName());
				categoryInfo.setCategoryDepth(1);
				categoryInfo.setParentCategoryCode(DTOtmp.getMainCategoryCode());
				
				categoryInfoList.add(categoryInfo);
				//����ī�װ��� �̿��� ������ �� ����ī�װ��� ����Ʈ�� �ִ´�.
			}
		}
		System.out.println("for�� ��");
		return categoryInfoList; 
	}
	
	public CategoryInfo getCategoryInfo() {
		return categoryInfo;
	}
	public void setCategoryInfo(CategoryInfo categoryInfo) {
		this.categoryInfo = categoryInfo;
	}
	
}
