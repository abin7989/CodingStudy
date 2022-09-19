package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;
	private static MemberService memberService= new MemberServiceImpl(); 
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}
	public static MemberService getMemberService() {
		return memberService;
	}
	@Override
	public int idCheck(String userId) throws Exception {
		
		return memberDao.idCheck(userId);
	}

	@Override
	public void joinMember(MemberDto memberDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberDto loginMember(String userId, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
