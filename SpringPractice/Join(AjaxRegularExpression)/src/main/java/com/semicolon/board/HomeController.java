package com.semicolon.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semicolon.board.dto.MemberDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home() {

		
		return "home";
	}
	@RequestMapping(value = "/MemberJoin")
	public String MemberJoin() {
		
		return "Member/MemberJoin";
	}
	
}
