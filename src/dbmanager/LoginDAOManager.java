package dbmanager;

import dao.MemberDAO;
import dao.HouseOwnerDAO;
import dao.HotelManagerDAO;

/**
 * Application계층 매니져 LoginManager에서 로그인 요청을 받아 처리하는DB계층 매니저 클래스 
 * @author 화섭
 *
 */
public class LoginDAOManager 
{
	private MemberDAO memberDAO;
	private HouseOwnerDAO houseOwnerDAO;
	private HotelManagerDAO hotelManagerDAO;
	
	/**
	 * 기본생성자로 MemberDAO, HouseOwnerDAO 그리고 HotelManagerDAO를 인스턴스화한다
	 */
	public LoginDAOManager()
	{
		memberDAO=new MemberDAO();
		houseOwnerDAO=new HouseOwnerDAO();
		hotelManagerDAO=new HotelManagerDAO();
	}
	
	/**
	 * LoginManager로부터 이메일과 비밀번호를 전달받아 이에 해당하는 회원의 코드를 MemberDAO에 요청하고 그 결과를 전달한다
	 * @param email 사용자가 입력한 이메일
	 * @param password 사용자가 입력한 비밀번호
	 * @return 입력한 정보에 해당하는 사용자의 회원코드
	 */
	public String getMemberCode(String email, String password)
	{
		return memberDAO.selectCode(email, password);
	}
	
	/**
	 * 사용자가 이메일을 잊어버렸을 경우 LoginManager로부터 이름과 전화번호를 전달받아 이에 해당하는 회원의 이메일을 MemberDAO에 요청하고 그 결과를 전달한다
	 * @param name 사용자가 입력한 이름
	 * @param phone 사용자가 입력한 전화번호
	 * @return 입력한 정보에 해당하는 회원 이메일
	 */
	public String getEmail(String name, String phone)
	{
		return memberDAO.selectEmail(name, phone);
	}
	
	/**
	 * 비밀번호를 잊어버렸을 경우 LoginManager로부터 이메일과 이름을 전달받아 이에 해당하는 회원의 비밀번호를 MemberDAO에 요청하고 그 결과를 전달한다
	 * @param email 사용자가 입력한 이메일
	 * @param name 사용자가 입력한 이름
	 * @return 입력한 정보에 해당하는 회원의 비밀번호
	 */
	public String getPassword(String email, String name)
	{
		return memberDAO.selectPassword(email, name);
	}
	
	/**
	 * 사용자가 입력한 비밀번호가 잘못되었는지 잘못된 이메일인지 확인하기 위해 LoginManger로부터 이메일을 전달받아 이에 해당하는 회원의 비밀번호를 MemberDAO에 요청하고 그결과를 전달한다
	 * @param email 사용자가 입력한 이메일
	 * @return 입력한 정보에 해당하는 회원의 비밀번호
	 */
	public String getPassword(String email)
	{
		return memberDAO.selectPassword(email);
	}
	
	/**
	 * LoginManager로부터 회원코드를 전달받아 이에 해당하는 집주인 코드가 있는지 HouseOwnerDAO에 요청하고 그결과를 전달한다
	 * @param memberCode 회원 고유식별코드
	 * @return 회원코드에 해당하는 집주인코드
	 */
	public String getHouseOwnerCode(String memberCode)
	{
		return houseOwnerDAO.selectHouseOwnerCode(memberCode);
	}
	
	/**
	 * LoginManager로부터 회원코드를 전달받아 이에 해당하는 숙박업체 코드가 이는데 HotelManagerDAO에 요청하고 그 결과를 리턴한다
	 * @param memberCode 회원 고유식별코드
	 * @return 회원 코드에 해당하는 숙박업체코드
	 */
	public String getHotelManageCode(String memberCode)
	{
		return hotelManagerDAO.selectHotelManagerCode(memberCode);
	}
	

}
