package com.semicolon.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semicolon.test.dao.TestDAO;

@Service
public class TestService {
	
	@Autowired
	private TestDAO testdao;
	
	public void insertDB(String data1) {
		testdao.insertDB(data1);
	}

}
