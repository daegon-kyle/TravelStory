package model;
/**
 * 길찾기정보를 캡슐화 하고 있는 클래스 
 * @author 영한
 *
 */
public class PathFindingInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6457646706114457617L;
	/**
	 * 출발지명
	 */
	private String departureName;
	/**
	 * 도착지명 
	 */
	private String destinationName;
	/**
	 * null생성자 
	 */
	public PathFindingInfo() {
	}
/**
 * 출발지명, 도착지명을 초기화하는 생성자 
 * @param departureName 출발지명
 * @param destinationName 도착지명
 */
	public PathFindingInfo(String departureName, String destinationName) {
		this.departureName = departureName;
		this.destinationName = destinationName;
	}
/**
 * 출발지명을 반환한다. 
 * @return 출발지명
 */
	public String getDepartureName() {
		return departureName;
	}
/**
 * 출발지명을 세팅한다. 
 * @param departureName 출발지명 
 */
	public void setDepartureName(String departureName) {
		this.departureName = departureName;
	}
/**
 * 목적지를 반환한다. 
 * @return 목적지 
 */
	public String getDestinationName() {
		return destinationName;
	}
/**
 * 목적지를 세팅한다. 
 * @param destinationName 목적지명
 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	
	
}
