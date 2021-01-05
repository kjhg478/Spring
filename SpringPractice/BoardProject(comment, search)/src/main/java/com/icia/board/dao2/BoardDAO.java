package com.icia.board.dao2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public int insertDB(BoardDTO board) {
		return sql.insert("board.insertDB", board);
	}

	public List<Object> selectDB(BoardDTO board) {
		return sql.selectList("board.selectDB", board);
		
	}

	public BoardDTO writeview(BoardDTO board) {
		sql.update("board.writeview", board);
		
		return board;
	}
	
	public BoardDTO writeupdate(BoardDTO board) {
		
		return sql.selectOne("board.writeupdate", board);
		
	}

	public int writemodify(BoardDTO board) {
		
		return sql.update("board.writemodify", board);
	}

	public int writedelete(BoardDTO board) {
		
		return sql.delete("board.writedelete", board);
	}

	public int writefile(BoardDTO board) {
		
		return sql.insert("board.writefile", board);
	}

	public int listCount() {
		
		return sql.selectOne("board.listcount");
	}

	public List<BoardDTO> listpaging(PageDTO paging) {
		return sql.selectList("board.listpaging", paging);
	}

	public List<BoardDTO> boardSearch(String searchtype, String keyword) {
		// map
		Map<String, String>searchMap = new HashMap<String, String>();
		searchMap.put("type", searchtype);
		searchMap.put("word", keyword);

		return sql.selectList("board.boardSearch", searchMap);
	}



}
