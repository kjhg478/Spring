package com.prectice.dan.contoller;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.prectice.dan.beans.MemberBean;
import com.prectice.dan.service.MemberService;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired 
	MemberService ms;
	
	@RequestMapping(value = "/goRegMember", method = RequestMethod.GET)
	public String goRegMember(Locale locale, Model model) {
		
		return "member/regMember";
	}
	
	@RequestMapping(value = "/goLogin", method = RequestMethod.GET)
	public String goLogin(Locale locale, Model model) {
		
		return "member/glogin";
	}
	
	// 아이디 중복체크
	@RequestMapping(value = "/checkid", method = RequestMethod.POST)
	public @ResponseBody int checkid(@RequestParam("uid") String uid) {
		
		return ms.checkid(uid);
	}
	
	// 회원 등록
	@RequestMapping(value = "/regMember", method = RequestMethod.POST)
	public @ResponseBody int regMember(@ModelAttribute MemberBean mmb) throws IllegalStateException, IOException {

		return ms.regMember(mmb);
	}
	
}
