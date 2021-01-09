package com.prectice.dan.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prectice.dan.beans.MemberBean;

@Repository
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sql;

	public int checkid(String uid) {
			
		return sql.selectOne("member.checkid",uid);
	}

	public int regMember(MemberBean mmb) {
		
		return sql.insert("member.regMember",mmb);
	}

}
