package com.dan.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dan.board.dto.DataTransferObject;

@Repository
public class DataAccessObject {
	
	@Autowired
	private SqlSessionTemplate sql;

	public int regBoard(DataTransferObject dto) {
			
		
		return sql.insert("Board.regBoard",dto);
	}

	public List<DataTransferObject> getBoardList() {

		return sql.selectList("Board.getBoardList");
		
	}

	public DataTransferObject getBoard(DataTransferObject dto) {
			
			sql.update("Board.getBoard",dto);
		
		return dto;
	}

}
