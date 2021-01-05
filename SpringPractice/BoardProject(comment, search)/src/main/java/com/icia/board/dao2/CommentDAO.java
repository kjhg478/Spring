package com.icia.board.dao2;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.CommentDTO;

@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public int commentWrite(CommentDTO comment) {
		
		return sql.insert("comment.commentWrite", comment);
	}

	public List<CommentDTO> commentList(int cbnumber) {
		System.out.println(cbnumber);
		return sql.selectList("comment.commentList", cbnumber);
	}



}
