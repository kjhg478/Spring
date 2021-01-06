package com.semicolon.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.semicolon.board.dto.MemberDTO;
import com.semicolon.board.service.MemberService;


@Controller
// 컨트롤러 어노테이션
public class MemberController {
	private ModelAndView mav;
	
	@Autowired
	private MemberService ms;
	
	

	@RequestMapping(value = "/Login")
	public ModelAndView Login(MemberDTO member) {
		mav = ms.login(member);
		return mav;
	}
	@RequestMapping(value = "/memberJoin")
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) {
		mav = ms.memberJoin(member);
		return mav;
	}
	@RequestMapping(value = "/idCheck")
	public @ResponseBody int idCheck(@RequestParam("id") String id) {
		int result = ms.idcheck(id);
		return result;
	}
}
