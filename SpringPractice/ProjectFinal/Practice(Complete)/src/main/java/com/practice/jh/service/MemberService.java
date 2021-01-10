
package com.practice.jh.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.practice.jh.dao.MemberDao;
import com.practice.jh.beans.MemberBean;

@Service
public class MemberService {
	
	@Autowired
	MemberDao md;
	
	ModelAndView mav;

	public int checkid(String uid) {
			
		return md.checkid(uid);
	}

	public int regMember(MemberBean mmb) throws IllegalStateException, IOException {
		
		// get multifile
		MultipartFile uprofile = mmb.getUprofile();
		// set filename
		String filename = uprofile.getOriginalFilename();
		// mod filename
		filename = System.currentTimeMillis() +"_"+ filename;
		// set filePath
		String filePath = "D:\\javaspace\\Spring\\Practice\\Practice\\src\\main\\webapp\\resources\\upload\\"+filename;			
		// set dto new filename
		mmb.setUprofilename(filename);
		// check file is empty
		if(!uprofile.isEmpty()) {
			uprofile.transferTo(new File(filePath));
		}
		
		// insert database and return
		
		return md.regMember(mmb);
	}

}
