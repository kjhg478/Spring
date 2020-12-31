package com.dan.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dan.board.dao.DataAccessObject;
import com.dan.board.dto.DataTransferObject;

@Service
public class BoardService {
	
	@Autowired
	private DataAccessObject dao;
	
	ModelAndView mav;
	
	public ModelAndView regBoard(DataTransferObject dto) {
		
		mav = new ModelAndView();
			
		if(dao.regBoard(dto)>0) {
				mav.addObject("is","성공하였습니다.");
				mav.setViewName("Board/result");
			}else {
				mav.addObject("is","실패하였습니다.");
				mav.setViewName("Board/result");
			}
		
		return mav;
	}

	public ModelAndView getBoardList() {
		
		mav = new ModelAndView();
			
		List<DataTransferObject> list = dao.getBoardList();
		mav.addObject("list",list);	
		mav.setViewName("Board/List");	
		
		return mav;
	}

	public ModelAndView getBoard(DataTransferObject dto) {
		
			mav =  new ModelAndView();
			dto = dao.getBoard(dto);
			mav.addObject("board",dto);
			mav.setViewName("Board/View");
		
		return mav;
	}

}
