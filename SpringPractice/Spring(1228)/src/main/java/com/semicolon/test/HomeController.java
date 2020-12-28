package com.semicolon.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.semicolon.test.service.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// controller에서 값을 담아 화면으로 가져가기
	// 화면에 값을 출력하려면 어떤 방식으로 이동했나? dispatch, redirect
	// 어떤 jsp에 어떤 데이터를 출력하고자 할 때 사용하는 클래스
	ModelAndView mav;
	
	@Autowired
	// 주입(injection) 기능 활용
	private TestService testService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// Request 방식 : get, post
	// rest 방식 : get, post, put(patch), delete
	// Method를 안쓰면 get, post 모두 받을 수 있음
	@RequestMapping(value = "/testview")
	public String testview() {

		return "testview";
	}
	@RequestMapping(value = "/param")
	public ModelAndView param(@RequestParam("param1") String param1,
							  @RequestParam("param2") String param2) {
		System.out.println(param1);
		System.out.println(param2);
		// param1, param2를 가지고 testview2.jsp로 이동하기
		mav = new ModelAndView();
		// mav에 파라미터 담기
		mav.addObject("pa1", param1);
		mav.addObject("pa2", param2);
		// mav에 목적지 (출력할 jsp) 지정
		mav.setViewName("testview2");
		
		return mav;
	}
	
	@RequestMapping(value = "insert")
	public String insertDB(@RequestParam("data1") String data1) {
		testService.insertDB(data1);
		
		return "home";
	}

}

