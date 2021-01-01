package com.semicolon.member;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.semicolon.member.dto.MemberDTO;
import com.semicolon.member.service.MemberService;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private ModelAndView mav;

	@Autowired
	private MemberService memberservice;

	@Autowired
	private HttpSession session;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		
		return "home";
	}
	@RequestMapping(value = "/MemberJoin", method = RequestMethod.GET)
	public String MemberJoin() {

		
		return "MemberJoin";
	}
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String Login() {

		
		return "Login";
	}
	
	@RequestMapping(value = "/join")
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) {
		mav = new ModelAndView();
		mav = memberservice.insertDB(member);
		
		
		return mav;
	}
	@RequestMapping(value = "/login")
	public ModelAndView memberLogin(@ModelAttribute MemberDTO member) {
		mav = memberservice.selectDB2(member);
		
		return mav;
	}
	@RequestMapping(value = "/SelectList")
	public ModelAndView selectList(@ModelAttribute MemberDTO member) {
		
		mav = memberservice.selectList(member);
		
		return mav;
	}
	@RequestMapping(value = "/MemberView")
	public ModelAndView MemberView(@RequestParam("mid") String view) {
		
		mav = memberservice.MemberView(view);
		
		return mav;
	}
	@RequestMapping(value = "/MemberDelete")
	public ModelAndView MemberDelete(@RequestParam("mid") String view) {
		
		mav = memberservice.MemberDelete(view);
		
		return mav;
	}
	@RequestMapping(value = "/MemberInfo")
	public ModelAndView MemberInfo(@RequestParam("mid") String view) {
		
		mav = memberservice.MemberInfo(view);
		
		return mav;
	}
	@RequestMapping(value = "/MemberModify")
	public ModelAndView MemberModify(
									@ModelAttribute MemberDTO member) {
		
		mav = memberservice.MemberModify(member);
		
		return mav;
	}
	@RequestMapping(value="/logout")
	public String memberLogout() {
		session.invalidate();
		return "Login";
	}
	// 아이디 중복확인
	@RequestMapping(value="/idoverlap")
	public @ResponseBody String idOverlap(@RequestParam("mid") String mid) {
		// responseBody 텍스트를 그대로 리턴 해줄 수 있게함
		System.out.println("넘어온값"+mid);
		String resultMsg = memberservice.idOverlap(mid);
		
		
		return resultMsg;
	}
	// ajax 이용한 상세조회
	@RequestMapping(value = "/memberviewajax")
	public @ResponseBody MemberDTO memberViewAjax(@RequestParam("mid") String mid) {
		MemberDTO memberView = memberservice.memberViewAjax(mid);
		return memberView;
	}

}
