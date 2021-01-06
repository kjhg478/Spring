package com.semicolon.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semicolon.board.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int login(MemberDTO member) {
		System.out.println(member);
		return sql.selectOne("Member.memberLogin", member);
	}

	public int memberJoin(MemberDTO member) {
		
		return sql.insert("Member.memberJoin", member);
	}

	public int idcheck(String id) {
		return sql.selectOne("Member.idcheck", id);
	}

}
