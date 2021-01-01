package com.semicolon.member.dao2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semicolon.member.dto.MemberDTO;


@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public int insertDB(MemberDTO member) {
		return sql.insert("Member.insertDB", member);
	}

	public int selectDB(MemberDTO member) {
		int result = sql.selectOne("Member.selectDB", member);

		return result;
	}

	public MemberDTO selectDB2(MemberDTO member) {
		return sql.selectOne("Member.selectDB2", member);
		

	}

	public List<Object> selectList(MemberDTO member) {
		
		return sql.selectList("Member.selectList", member);
	}

	public MemberDTO MemberView(String view) {
		System.out.println(view);

		return sql.selectOne("Member.memberView", view);
	}

	public int MemberDelete(String view) {
		
		return sql.delete("Member.memberDelete", view);
	}

	public MemberDTO MemberInfo(String view) {
		
		return sql.selectOne("Member.memberInfo", view);
	}

	public int MemberModify(MemberDTO member) {
		System.out.println(member);
		return sql.update("Member.memberUpdate", member);
	}

	public String idOverlap(String mid) {
		return sql.selectOne("Member.idOverlap", mid);
	}

}
