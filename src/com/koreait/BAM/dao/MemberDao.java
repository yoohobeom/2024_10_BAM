package com.koreait.BAM.dao;

import java.util.ArrayList;
import java.util.List;

import com.koreait.BAM.dto.Member;
import com.koreait.BAM.util.Util;

public class MemberDao {

	private List<Member> members;
	
	public MemberDao() {
		this.members = new ArrayList<>();
	}
	
	public boolean isLoginIdDup(String loginId) {
		for (Member member : members) {
			if (member.getMemberId().equals(loginId)) {
				return true;
			}
		}
		return false;
	}

	public void joinMember(int lastMemberId, String loginId, String loginPw, String name) {
		Member member = new Member(lastMemberId, Util.getDateStr(), loginId, loginPw, name);
		members.add(member);
	}

}