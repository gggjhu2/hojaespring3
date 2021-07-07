package com.hojae.spring.member.model.service;

import com.hojae.spring.member.model.vo.Member;

public interface MemberService {

	
	Member selectOneMember(String id);

	int insertMember(Member member);

}
