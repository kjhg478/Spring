package com.icia.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao2.BoardDAO;
import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;


@Service
public class BoardService {
	private ModelAndView mav;
	
	@Autowired
	private BoardDAO bd;
	
	public ModelAndView insertDB(BoardDTO board) {
		mav = new ModelAndView();
		int result = bd.insertDB(board);
		
		if(result > 0) {
			mav.setViewName("home");
		}else {
			mav.setViewName("writefail");
		}
		return mav;
	}

	public ModelAndView selectDB(BoardDTO board) {
		mav = new ModelAndView();
		List<Object> list = bd.selectDB(board);
		if(list != null) {
			mav.addObject("boardlist", list);
			mav.setViewName("writelist");
		}else {
			mav.setViewName("writefail");
		}
		
		return mav;
	}

	public ModelAndView writeview(BoardDTO board, int page) {
		mav = new ModelAndView();
		
		board = bd.writeview(board);
		if(board != null) {
			mav.addObject("Boardinfo", board);
			mav.addObject("page", page);
			mav.setViewName("writeview");
		}else {
			mav.setViewName("writefail");
		}
		return mav;
	}
	
	public ModelAndView writeupdate(BoardDTO board) {
		mav = new ModelAndView();
		
		board = bd.writeupdate(board);
		
		if(board != null) {
			mav.addObject("boardupdate", board);
			mav.setViewName("writemodify");
		}else {
			mav.setViewName("writefail");
		}
		return mav;
	}

	public ModelAndView writemodify(BoardDTO board) {
		mav = new ModelAndView();
		
		int result = bd.writemodify(board);

		if (result > 0) {
			mav.addObject("bnum", board.getBnum());
			mav.setViewName("redirect:/writeview");
		}else {
			mav.setViewName("writefail");
		}
		return mav;
	}

	public ModelAndView writedelete(BoardDTO board) {
		mav = new ModelAndView();
		
		int result = bd.writedelete(board);
		System.out.println(result);

		if(result > 0) {
			mav.setViewName("redirect:/writelist");
		}else {
			mav.setViewName("writefail");
		}
		return mav;
	}

	public ModelAndView writefile(BoardDTO board) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile bfile = board.getBfile();
		String bfilename = bfile.getOriginalFilename();
		bfilename = System.currentTimeMillis() + "_" + bfilename;
		
		String savePath = "D:\\Spring\\BoardProject\\src\\main\\webapp\\resources\\uploadfile\\"+bfilename;
		if(!bfile.isEmpty()) {
			bfile.transferTo(new File(savePath));
		}
		board.setBfilename(bfilename);
		int writeResult = bd.writefile(board);
		System.out.println(board);
		if(writeResult > 0) {
			mav.setViewName("redirect:/writelist");
		}else {
			mav.setViewName("writefail");
		}
		return mav;
	}
	// 페이징 처리용 상수 선언
	private static final int PAGE_LIMIT = 3; // 한페이지에 보여질 글 갯수
	private static final int BLOCK_LIMIT = 3; // 한 화면에 보여질 페이지 수
	
	public ModelAndView writelistpage(int page) {
		mav = new ModelAndView();
		// 전체 글 갯수 가져오기
		int listCount = bd.listCount();
		// 현재 페이지에 보여줘야 할 글 범위 지정 (전체글을 어떤 기준에 의해 정렬을 하고 뽑아와야 함)
		int startRow = (page-1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		// 1페이지 : 1~3, 2페이지 : 4~6, 3페이지 : 7~9
		PageDTO paging = new PageDTO();
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		List<BoardDTO> boardList = bd.listpaging(paging);
		// 14/3 = 4.66666 ==> 5 4.1 ==> 5
		// 14/3 = 4
		int maxPage = (int)(Math.ceil((double)listCount / PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		//1, 4, 7, 10, 13 (block_limit = 3)
		//11, 21, 31, 41, 51 (block_limit = 10)

		int endPage = startPage + BLOCK_LIMIT - 1;
		// 3, 6, 9, 12
		// 10, 20, 30, 40
		// 총 필요한 페이지는 5개인데 endPage가 6까지 나올 필요가 없기 때문에 endPage 값을 maxPage랑 같게 함.
		if(endPage > maxPage)
			endPage = maxPage;
		
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		mav.addObject("paging", paging);
		mav.addObject("boardlist", boardList);
		mav.setViewName("writelistpaging");
		//mav.setViewName("boardv/writelistpage");
		// boardv란 폴더를 만들어서 이용가능
		return mav;
	}





}
