package model;

import java.util.List;
import java.util.ArrayList;

public class MemberInfoList implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4765714579632345171L;
	private List<MemberInfo> memberList;

	public MemberInfoList() {
		this(new ArrayList<MemberInfo>());
	}
	public MemberInfoList(List<MemberInfo> memberList) {
		super();
		this.memberList = memberList;
	}
	
	public List<MemberInfo> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<MemberInfo> memberList) {
		this.memberList = memberList;
	}
	
	public boolean addMemberInfo(MemberInfo memberInfo){
		if(memberList.add(memberInfo))
			return true;
		else
			return false;
	}
	public MemberInfo deleteMemberInfo(String email){
		for(MemberInfo temp:memberList){
			if(temp.getEmail().equals(email)){
				memberList.remove(temp);
				return temp;
			}
		}
		return null;
	}
	public MemberInfo searchMemberInfo(String email){
		for(MemberInfo temp:memberList){
			if(temp.getEmail().equals(email)){
				return temp;
			}
		}
		return null;
	}
	public MemberInfo reviseMemberInfo(String email, MemberInfo newMemberInfo){
		for(MemberInfo temp:memberList){
			if(temp.getEmail().equals(email)){
				int index=memberList.indexOf(temp);
				memberList.set(index, newMemberInfo);
				return temp;
			}
		}
		return null;
	}
}
