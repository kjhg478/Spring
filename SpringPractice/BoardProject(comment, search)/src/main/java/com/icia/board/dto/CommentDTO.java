package com.icia.board.dto;

import lombok.Data;

@Data
public class CommentDTO {
	private int cnumber; // 댓글번호
	private int cbnumber; // 게시글번호
	private String cwriter; 
	private String ccontents;
}
