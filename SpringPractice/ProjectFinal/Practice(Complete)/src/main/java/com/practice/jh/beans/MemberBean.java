package com.practice.jh.beans;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberBean {
	private String uid;
	private String upwd;
	private String uname;
	private String uadd;
	private String ugender;
	private String ubirth;
	private String uemail;
	private String uphone;
	private MultipartFile uprofile;
	private String uprofilename;
}
