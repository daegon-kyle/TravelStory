package manager;

import java.util.Calendar;

import converter.ConvertGregorianCalendar;
import dbmanager.MemberDAOManager;
import model.MemberInfo;

public class MemberJoinManager {
	private MemberInfo memberInfo;

	public MemberJoinManager() {
		this(new MemberInfo());
	}
	public MemberJoinManager(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	
	public MemberInfo getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	
	public boolean join()
	{
		System.out.println("여기는 MemberJoinManager쪽이에요");
		
		MemberDAOManager memberDAOManager=new MemberDAOManager();
		return memberDAOManager.save(memberInfo); 
	}
}
