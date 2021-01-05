package com.icia.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao2.CommentDAO;
import com.icia.board.dto.CommentDTO;

@Service
public class CommentService {
	
	@Autowired
	private CommentDAO cdao;
	
	public List<CommentDTO> commentWrite(CommentDTO comment) {
		int writeResult = cdao.commentWrite(comment);

		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		if(writeResult > 0) {
			commentList = cdao.commentList(comment.getCbnumber());
			System.out.println(commentList);

		}else {
			commentList = null;
		}
		System.out.println("??"+commentList);
		return commentList;
	}

	public List<CommentDTO> commentlist(int bnum) {
		List<CommentDTO> result = cdao.commentList(bnum);
	
		return result;
	}

}
