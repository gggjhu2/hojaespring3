package com.hojae.spring.member.model.dao;

import com.hojae.spring.member.model.vo.Member;


public interface MemberDao {

	
	
	Member selectOneMember(String id);

	int insertMember(Member member);

	int updateMember(Member member);
	
}
