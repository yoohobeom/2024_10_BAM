package com.koreait.BAM.service;

import com.koreait.BAM.dao.MemberDao;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	public boolean isLoginIdDup(String loginId) {
		return memberDao.isLoginIdDup(loginId);
	}
	
	public void joinMember(int lastMemberId, String loginId, String loginPw, String name) {
		memberDao.joinMember(lastMemberId, loginId, loginPw, name);
	}
}