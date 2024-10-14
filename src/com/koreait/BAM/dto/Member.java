package com.koreait.BAM.dto;

public class Member {
	private int num;
	private String regDate;
	private String memberId;
	private String memberPw;
	private String memberName;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Member(int num, String regDate, String memberid, String memberPw, String memberName) {
		this.num = num;
		this.regDate = regDate;
		this.memberId = memberid;
		this.memberPw = memberPw;
		this.memberName = memberName;
	}
}
