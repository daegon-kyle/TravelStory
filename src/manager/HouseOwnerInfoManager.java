//작성날짜 : 2014/7/27
//작성자 : 이화섭

package manager;

import model.HouseOwnerEssentialInfo;
import dbmanager.HouseOwnerInfoDAOManager;
/**
 * 집주인정보를 관리하기 위한 클래스
 * @author 대곤
 *
 */
public class HouseOwnerInfoManager {
	/**
	 * 집주인 필수입력사항 정보
	 */
	private HouseOwnerEssentialInfo houseOwnerEssentialInfo;
	/**
	 * 널생성자
	 */
	public HouseOwnerInfoManager() {
		this(new HouseOwnerEssentialInfo());
	}
/**
 * 기본생성자
 * @param houseOwnerEssentialInfo 집주인 필수입력사항정보
 */
	public HouseOwnerInfoManager(HouseOwnerEssentialInfo houseOwnerEssentialInfo) {
		this.houseOwnerEssentialInfo = houseOwnerEssentialInfo;
	}
/**
 * 집주인정보 반환
 * @return 집주인정보 반환
 */
	public HouseOwnerEssentialInfo getHouseOwnerEssentialInfo() {
		return houseOwnerEssentialInfo;
	}
/**
 * 집주인정보 설정
 * @param houseOwnerEssentialInfo 집주인정보
 */
	public void setHouseOwnerEssentialInfo(
			HouseOwnerEssentialInfo houseOwnerEssentialInfo) {
		this.houseOwnerEssentialInfo = houseOwnerEssentialInfo;
	}
	/**
	 * HouseOwnerInfoDAOManager의 save메소드를 통해 DB에 저장
	 * @param memberCode 회원코드
	 * @return 추가된 집주인정보
	 */
	public boolean addHouseOwnerInfo(String memberCode)
	{
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager=new HouseOwnerInfoDAOManager();
		return houseOwnerInfoDAOManager.save(memberCode, houseOwnerEssentialInfo);
	}
	/**
	 *  HouseOwnerInfoDAOManager의 modify메소드를 통해 DB에 저장
	 * @param houseOwnerCode 집주인 코드
	 * @return
	 */
	public boolean modifyHouseOwnerInfo(String houseOwnerCode)
	{
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager=new HouseOwnerInfoDAOManager();
		return houseOwnerInfoDAOManager.modify(houseOwnerCode, houseOwnerEssentialInfo);
	}
	/**
	 *  HouseOwnerInfoDAOManager의 delete메소드를 통해 DB에 저장
	 * @param houseOwnerCode 집주인코드
	 * @return 삭제 성공여부
	 */
	public boolean deleteHouseOwnerInfo(String houseOwnerCode)
	{
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager=new HouseOwnerInfoDAOManager();
		return houseOwnerInfoDAOManager.delete(houseOwnerCode);
	}
	
	public HouseOwnerEssentialInfo getHouseOwnerInfo(String houseOwnerCode) 
	{
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager=new HouseOwnerInfoDAOManager();
		return houseOwnerInfoDAOManager.getHouseOwner(houseOwnerCode);
	}
}
