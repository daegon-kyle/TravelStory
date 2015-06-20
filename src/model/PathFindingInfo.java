package model;
/**
 * ��ã�������� ĸ��ȭ �ϰ� �ִ� Ŭ���� 
 * @author ����
 *
 */
public class PathFindingInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6457646706114457617L;
	/**
	 * �������
	 */
	private String departureName;
	/**
	 * �������� 
	 */
	private String destinationName;
	/**
	 * null������ 
	 */
	public PathFindingInfo() {
	}
/**
 * �������, ���������� �ʱ�ȭ�ϴ� ������ 
 * @param departureName �������
 * @param destinationName ��������
 */
	public PathFindingInfo(String departureName, String destinationName) {
		this.departureName = departureName;
		this.destinationName = destinationName;
	}
/**
 * ��������� ��ȯ�Ѵ�. 
 * @return �������
 */
	public String getDepartureName() {
		return departureName;
	}
/**
 * ��������� �����Ѵ�. 
 * @param departureName ������� 
 */
	public void setDepartureName(String departureName) {
		this.departureName = departureName;
	}
/**
 * �������� ��ȯ�Ѵ�. 
 * @return ������ 
 */
	public String getDestinationName() {
		return destinationName;
	}
/**
 * �������� �����Ѵ�. 
 * @param destinationName ��������
 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	
	
}
