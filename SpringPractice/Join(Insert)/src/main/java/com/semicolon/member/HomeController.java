package com.semicolon.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semicolon.member.dto.MemberDTO;
import com.semicolon.member.service.MemberService;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberservice;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		
		return "home";
	}
	@RequestMapping(value = "/MemberJoin", method = RequestMethod.GET)
	public String MemberJoin() {

		
		return "MemberJoin";
	}
	
	@RequestMapping(value = "/join")
	public String memberJoin(@ModelAttribute MemberDTO member) {

		memberservice.insertDB(member);
		return "Login";
	}
	
}
