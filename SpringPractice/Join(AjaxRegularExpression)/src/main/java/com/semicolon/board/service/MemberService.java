package com.semicolon.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.semicolon.board.dao.MemberDAO;
import com.semicolon.board.dto.MemberDTO;

@Service
public class MemberService {
	private ModelAndView mav;
	
	@Autowired
	private MemberDAO md;
	
	public ModelAndView login(MemberDTO member) {
		mav = new ModelAndView();
		int result = md.login(member);
		System.out.println(result);
		if(result > 0) {
			mav.setViewName("Member/Main");
		}else {
			mav.setViewName("Member/Fail");
		}
		return mav;
	}

	public ModelAndView memberJoin(MemberDTO member) {
		mav = new ModelAndView();
		int result = md.memberJoin(member);
		if(result > 0) {
			mav.setViewName("home");
		}else {
			mav.setViewName("Fail");
		}
		
		return mav;
	}

	public int idcheck(String id) {
		int result = md.idcheck(id);
		System.out.println(result);
		result = result > 0 ? 1:0;
		
		return result;
	}

}
