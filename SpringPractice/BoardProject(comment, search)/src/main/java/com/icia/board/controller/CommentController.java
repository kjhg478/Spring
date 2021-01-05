package com.icia.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.board.dto.CommentDTO;
import com.icia.board.service.CommentService;

@Controller
@RequestMapping("/comment/*")
// comment 주소의 형식으로 들어오는 녀석들은 다 저 controller가 받는다

public class CommentController {

	@Autowired
	private CommentService cs;
	
	// 이후의 주소는
	@RequestMapping(value="commentwrite")
	public @ResponseBody List<CommentDTO> commentWrite(@ModelAttribute CommentDTO comment) {
		List<CommentDTO> commentList = cs.commentWrite(comment);
		return commentList;
	}
	@RequestMapping(value="commentlist")
	public @ResponseBody List<CommentDTO> commentlist(@RequestParam int bnum) {
		List<CommentDTO> commentList = cs.commentlist(bnum);
		return commentList;
	}
}
