package com.hojae.spring.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hojae.spring.member.model.dao.MemberDao;
import com.hojae.spring.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	public MemberDao memberDao;



	@Override
	public Member selectOneMember(String id) {
		// TODO Auto-generated method stub
		return memberDao.selectOneMember(id);
	}

}
