package com.semicolon.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semicolon.member.dao2.MemberDAO;
import com.semicolon.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberdao;
	
	public void insertDB(MemberDTO member) {
		memberdao.insertDB(member);
	}

}
