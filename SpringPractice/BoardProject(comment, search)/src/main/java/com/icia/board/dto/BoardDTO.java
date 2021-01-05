package com.icia.board.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDTO {
private String bnum;
private String bwriter;
private String bpwd;
private String btitle;
private String bcontents;
private String bdate;
private int bhits;

private MultipartFile bfile;
private String bfilename;
}
