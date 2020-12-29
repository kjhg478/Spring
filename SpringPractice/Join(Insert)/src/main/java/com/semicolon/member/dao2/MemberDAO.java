package com.semicolon.member.dao2;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semicolon.member.dto.MemberDTO;


@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public void insertDB(MemberDTO member) {
		sql.insert("Member.insertDB", member);
	}

}
