package form;
/**
 * �����ο��� �湮��û�ϱ� ���� �ʼ������� �Է��ؾ��ϴ� �� Ŭ����
 * VisitRequestServlet���� ȣ�� 
 * @author ����
 *
 */
public class TouristEssentialInfoForm {
	/**
	 * �ڱ�Ұ�
	 */
	private String selfIntroduction;
	/**
	 * �湮 ���۳�¥
	 */
	private String visitStartDate;
	/**
	 * �湮 ����¥
	 */
	private String visitEndDate;
	/**
	 * �����ڼ�
	 */
	private String companionNum;
	/**
	 * ����
	 */
	private String job;
	/**
	 * null������ 
	 */
	public TouristEssentialInfoForm() {
		this("","","","","");
	}
	/**
	 * �ڱ�Ұ�, �湮������, �湮������, �����ڼ�, ������ �ʱ�ȭ�ϴ� ������ 
	 * @param selfIntroduction
	 * @param visitStartDate
	 * @param visitEndDate
	 * @param companionNum
	 * @param job
	 */
	public TouristEssentialInfoForm(String selfIntroduction,
			String visitStartDate, String visitEndDate, String companionNum,
			String job) {
		this.selfIntroduction = selfIntroduction;
		this.visitStartDate = visitStartDate;
		this.visitEndDate = visitEndDate;
		this.companionNum = companionNum;
		this.job = job;
	}

	/**
	 * �ڱ�Ұ��� ��ȯ�Ѵ�.
	 * @return �ڱ�Ұ� 
	 */
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
/**
 * �ڱ�Ұ��� �����Ѵ�.
 * @param selfIntroduction �ڱ�Ұ� 
 */
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
/**
 * �湮�������� ��ȯ�Ѵ�.
 * @return �湮������ 
 */
	public String getVisitStartDate() {
		return visitStartDate;
	}
/**
 * �湮�������� �����Ѵ�. 
 * @param visitStartDate �湮������
 */
	public void setVisitStartDate(String visitStartDate) {
		this.visitStartDate = visitStartDate;
	}
/**
 * �湮�������� ��ȯ�Ѵ�.
 * @return �湮������
 */
	public String getVisitEndDate() {
		return visitEndDate;
	}
/**
 * �湮�������� �����Ѵ�.
 * @param visitEndDate �湮������
 */
	public void setVisitEndDate(String visitEndDate) {
		this.visitEndDate = visitEndDate;
	}
/**
 * �����ڼ��� ��ȯ�Ѵ�.
 * @return �����ڼ� 
 */
	public String getCompanionNum() {
		return companionNum;
	}
/**
 * �����ڼ��� �����Ѵ�. 
 * @param companionNum �����ڼ� 
 */
	public void setCompanionNum(String companionNum) {
		this.companionNum = companionNum;
	}
/**
 * ������ ��ȯ�Ѵ�.
 * @return ����
 */
	public String getJob() {
		return job;
	}
/**
 * ������ �����Ѵ�.
 * @param job ����
 */
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
}
