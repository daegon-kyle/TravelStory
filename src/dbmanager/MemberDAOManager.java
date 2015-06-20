package dbmanager;

import dao.MemberDAO;
import dto.MemberDTO;
import model.MemberInfo;
import model.MemberInfoList;
import converter.ConvertGregorianCalendar; 
import java.util.GregorianCalendar;

/**
 * application계층 매니저인 MemberJoinManager 로부터 회원정보에 대한 요청을 받아 처리를  MemberDAO에 요청후 그 결과를 전달한다 
 * @author 화섭
 *
 */
public class MemberDAOManager 
{
	private MemberDAO memberDAO;
	
	/**
	 * 기본생성자로 MemberDAO를 인스턴스화한다
	 */
	public MemberDAOManager()
	{
		memberDAO=new MemberDAO();
	}
	
	/**
	 * 회원정보를 전달받아 db저장을 MemberDAO를 통해 요청하고 그결과를 전달한다
	 * @param memberInfo 가입할 회원정보
	 * @return 가입 성공여부
	 */
	public boolean save(MemberInfo memberInfo)
	{
		ConvertGregorianCalendar convertCalendar=new ConvertGregorianCalendar();
	
				
		String name=memberInfo.getName();
		String email=memberInfo.getEmail();
		String password=memberInfo.getPassword();
		String birthdate=convertCalendar.convert(memberInfo.getBirthDate());		
		String phone=memberInfo.getPhone();
		String gender=memberInfo.getGender(); 
		
		return memberDAO.insert("2", name, email, password, birthdate, phone, gender); //2는 멤버레벨코드로 일반회원을 나타낸다 
	}
	
	/**
	 * db에 저장됨 모든 회원의 정보 삭제를 MemberDAO를 통해 요청하고 그결과를 전달한다
	 * @return 삭제 성공여부
	 */
	public boolean deleteAll()
	{
		return memberDAO.deleteAll();		
	}
	
	/**
	 * 회원코드에 해당하는 회원의 정보를 찾아 삭제를 MemberDAO를 통해 요청하고 그 결과를 전달한다
	 * @param memberCode 회원코드
	 * @return 삭제 성공여부
	 */
	public boolean deleteMember(String memberCode)
	{
		return memberDAO.deleteMember(memberCode);		
	}
	
	/**
	 * 이메일과 비밀번호에 해당하는 회원의 정보를 찾아 삭제를 MemberDAO를 통해 요청하고 그 결과를 전달한다
	 * @param email 이메일
	 * @param password 비밀번호
	 * @return 삭제 성공여부
	 */
	public boolean deleteMember(String email, String password)
	{
		return memberDAO.deleteMember(email, password);
	}
	
	/**
	 * 등록된 모든 회원의 정보 검색을 MemberDAO를 통해 요청하고 그결과를 전달한다
	 * @return 등록되있는 모든 회원정보목록을 리턴한다
	 */
	public MemberInfoList getAll()
	{ 
		MemberInfoList memberInfoList=new MemberInfoList();
		
		for(MemberDTO member :memberDAO.selectAll())
		{
			MemberInfo memberInfo=changeToMemberInfo(member);
			memberInfoList.addMemberInfo(memberInfo);
		}
		return memberInfoList;
	}
	
	/**
	 * 회원코드에 해당하는 회원정보 검색을 MemberDAO를 통해 요청하고 그 결과를 전달한다
	 * @param memberCode 회원코드
	 * @return 회원코드에 해당하는 회원정보
	 */
	public MemberInfo getMemberInfo(String memberCode)
	{
		MemberDTO member=memberDAO.select(memberCode);
		
		return changeToMemberInfo(member);
	}
	
	/**
	 * 이메일에 해당하는 비밀번호 검색을 MemberDAO를 통해 요청하고 그 결과를 전달한다
	 * @param email 이메일
	 * @return 이메일에 해당하는 비밀번호를 전달한다
	 */
	public String getPassword(String email)
	{
		return memberDAO.selectPassword(email);
	}
	
	/**
	 * 회원코드에 해당하는 회원정보 수정을 MemberDAO를 통해 요청하고 그 결과를 전달한다
	 * @param memberCode 회원코드
	 * @param memberInfo 수정할 회원정보
	 * @return 수정 성공여부
	 */
	public boolean modify(String memberCode, MemberInfo memberInfo)
	{
		ConvertGregorianCalendar convertGregorianCalendar=new ConvertGregorianCalendar();
		
		String name=memberInfo.getName();
		String email=memberInfo.getEmail();
		String password=memberInfo.getPassword();
		String birthdate=convertGregorianCalendar.convert(memberInfo.getBirthDate());
		String phone=memberInfo.getPhone();
		String gender=memberInfo.getGender();
		
		return memberDAO.update(memberCode, name, email, password, birthdate, phone, gender);
	}
	
	/**
	 * 회원의 신용도 수정을 MembeDAO를 통해 요청하고 그 결과를 전달한다
	 * @param memberCode 회원코드
	 * @param reliability 신용도
	 * @return 수정성공여부
	 */
	public boolean modify(String memberCode, int reliability)
	{
		return memberDAO.update(memberCode, reliability);
	}
	
	/**
	 * 회원의 이메일주소 수정을 MemberDAO를 통해 요청하고 그결과를 전달한다
	 * @param memberCode 회원코드
	 * @param email 이메일
	 * @return 수정성공여부
	 */
	public boolean modify(String memberCode, String email)
	{
		return memberDAO.update(memberCode, email);
	}
	

	/**
	 * 회원 테이블 정보를 저장한 MemberDTO클래스를 계층간 이동을 위한 회원저장 클래스 MemberInfo로 변환하여 전달한다
	 * @param memberDTO 회원 테이블 정보를 저장한 클래스
	 * @return 회원정보를 계층건 전달할 MemberInfo 클래스
	 */
	public MemberInfo changeToMemberInfo(MemberDTO memberDTO)
	{
		ConvertGregorianCalendar convertGregorianCalendar=new ConvertGregorianCalendar();
		 
		String name=memberDTO.getName();
		String email=memberDTO.getEmail();
		String password=memberDTO.getPassword();
		GregorianCalendar birthDate =convertGregorianCalendar.convert(memberDTO.getBirthdate());
		String phone=memberDTO.getPhone();
		String gender=memberDTO.getGender();
		String myMemberCode=memberDTO.getMemberCode();
		String memberLevel=memberDTO.getLevelCode();
		int reliability=memberDTO.getReliability();
		
		MemberInfo memberInfo=new MemberInfo(name, email, password, birthDate, gender, phone, myMemberCode, memberLevel, reliability); 
		
		return memberInfo;
	}
}
