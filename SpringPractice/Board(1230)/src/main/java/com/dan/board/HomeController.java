package com.dan.board;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dan.board.dto.DataTransferObject;
import com.dan.board.service.BoardService;


@Controller
public class HomeController {
	
	@Autowired
	private BoardService bs;
	
	ModelAndView mav;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/Bwrite", method = RequestMethod.GET)
	public String Bwrite() {
		
		return "Board/Bwrite";
	}
	
	@RequestMapping(value = "/regBoard", method = RequestMethod.POST)
	public ModelAndView regBoard(@ModelAttribute DataTransferObject dto) {
		
			mav = bs.regBoard(dto);
		
		return mav;
	}
	
	@RequestMapping(value = "/Blist", method = RequestMethod.GET)
	public ModelAndView Blist() {
		
			mav = bs.getBoardList();
		
		return mav;
	}
	
	@RequestMapping(value = "/getBoard", method = RequestMethod.GET)
	public ModelAndView getBoard(@ModelAttribute DataTransferObject dto) {
		
			mav = bs.getBoard(dto);
		
		return mav;
	}
	
	
}
