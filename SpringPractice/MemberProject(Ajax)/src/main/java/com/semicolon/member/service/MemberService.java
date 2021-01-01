package com.semicolon.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.semicolon.member.dao2.MemberDAO;
import com.semicolon.member.dto.MemberDTO;

@Service
public class MemberService {
	private ModelAndView mav;

	@Autowired
	private MemberDAO memberdao;
	
	@Autowired
	private HttpSession session;
	
	public ModelAndView insertDB(MemberDTO member) {
		mav = new ModelAndView();
		int result = memberdao.insertDB(member);
		if(result>0) {
			mav.setViewName("Login");
		}else {
			mav.setViewName("JoinFail");
		}
		return mav;
	}

	public ModelAndView selectDB2(MemberDTO member) {
		mav = new ModelAndView();
		//int result = memberdao.selectDB(member);
		
		MemberDTO userinfo = memberdao.selectDB2(member);
		System.out.println(userinfo);
	
		if(userinfo != null) {
			session.setAttribute("mid", userinfo.getMid());
			mav.setViewName("Welcome");
			
		}else {
			mav.setViewName("LoginFail");
		}
		
		return mav;
	}

	public ModelAndView selectList(MemberDTO member) {
		mav = new ModelAndView();
		
		List<Object> list = memberdao.selectList(member);
		
		if(list != null) {

			mav.addObject("selectlist", list);
			mav.setViewName("SelectList");
		}else {
			mav.setViewName("LoginFail");
		}
		
		
		return mav;
	}

	public ModelAndView MemberView(String view) {
		MemberDTO member = memberdao.MemberView(view);
		System.out.println(member);
		if(member != null) {

			mav.addObject("memberView", member);
			mav.setViewName("MemberView");
		}else {
			mav.setViewName("LoginFail");
		}
		
		return mav;
	}

	public ModelAndView MemberDelete(String view) {
		int result = memberdao.MemberDelete(view);
		if(result > 0) {

			mav.setViewName("redirect:/SelectList"); // redirect:/주소값
		}else {
			mav.setViewName("LoginFail");
		}
		
		return mav;
	}

	public ModelAndView MemberInfo(String view) {
		MemberDTO member = memberdao.MemberView(view);
		System.out.println(member);
		if(member != null) {

			mav.addObject("MemberInfo", member);
			mav.setViewName("MemberInfo");
		}else {
			mav.setViewName("LoginFail");
		}
		
		return mav;
	}

	public ModelAndView MemberModify(MemberDTO member) {
		mav = new ModelAndView();
		member.setMid((String)session.getAttribute("mid"));
		
		int result = memberdao.MemberModify(member);
		
		if(result > 0) {

			mav.setViewName("redirect:/Login");
			session.invalidate();
		}else {
			mav.setViewName("LoginFail");
		}
		
		
		return mav;
	}

	public String idOverlap(String mid) {
		String checkResult = memberdao.idOverlap(mid);
		String resultMsg = null;
		if(checkResult == null) {
			resultMsg = "ok";
		}else
			resultMsg = "no";
		
		return resultMsg;
	}

	public MemberDTO memberViewAjax(String mid) {
		MemberDTO memberView = memberdao.MemberView(mid);
		return memberView;
	}

}
