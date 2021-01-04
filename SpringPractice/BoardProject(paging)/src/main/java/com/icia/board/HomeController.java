package com.icia.board;

import java.io.IOException;
import java.text.DateFormat;
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
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private ModelAndView mav;

	@Autowired
	private BoardService bs;

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		
		return "home";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		
		
		return "write";
	}
	@RequestMapping(value = "/writefile", method = RequestMethod.GET)
	public String file() {
		
		
		return "writefile";
	}

	@RequestMapping(value = "/write2")
	public ModelAndView write(@ModelAttribute BoardDTO board) {
		mav = new ModelAndView();
		mav = bs.insertDB(board);
		
		
		return mav;
	}
	@RequestMapping(value = "/writelist")
	public ModelAndView writelist(@ModelAttribute BoardDTO board) {
		mav = new ModelAndView();
		mav = bs.selectDB(board);
		
		
		return mav;
	}
	@RequestMapping(value = "/writeview")
	public ModelAndView writeview(@RequestParam(value="page", required=false, defaultValue="1")int page,
			@ModelAttribute BoardDTO board) {
		
		mav = bs.writeview(board, page);
		
		
		return mav;
	}
	@RequestMapping(value = "/writeupdate")
	public ModelAndView writeupdate(@ModelAttribute BoardDTO board) {
		
		mav = bs.writeupdate(board);
		return mav;
	}
	
	@RequestMapping(value = "/writemodify")
	public ModelAndView writemodify(@ModelAttribute BoardDTO board) {
		
		mav = bs.writemodify(board);
		return mav;
	}
	@RequestMapping(value = "/writedelete")
	public ModelAndView writedelete(@ModelAttribute BoardDTO board) {
		
		mav = bs.writedelete(board);
		return mav;
	}
	@RequestMapping(value="/writeFile")
	public ModelAndView writefile(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		mav = bs.writefile(board);
		return mav;
		
	}
	@RequestMapping(value="/writelistpage")
	public ModelAndView writelistpage(@RequestParam(value="page", required=false, defaultValue="1")int page ) {
		mav = bs.writelistpage(page);
		return mav;
		
	}
}
