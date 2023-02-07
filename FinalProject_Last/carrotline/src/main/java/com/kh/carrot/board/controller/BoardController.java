package com.kh.carrot.board.controller;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.carrot.board.model.service.BoardService;
import com.kh.carrot.board.model.vo.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//공지사항게시판리스트
	@RequestMapping("list.bo")
		public ModelAndView BoardList(ModelAndView mv) {
			
			ArrayList<Board> list = boardService.selectList();
			
			mv.addObject("list", list);
			System.out.println(list);
			mv.setViewName("board/boardList");
			
			return mv;
		}
	
	//공지사항 상세보기
	@RequestMapping("detail.bo")
	public ModelAndView detailBoard(int bno,
									ModelAndView mv) {
				
		int result = boardService.increaseCount(bno);
		
		if(result>0) {
			Board b = boardService.selectBoard(bno);
			mv.addObject("b",b).setViewName("board/boardDetailView");
		}else {
			mv.addObject("errorMsg", "게시글 조회 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
	
	//관리자 공지사항 작성폼
	@GetMapping("writeForm.bo")
		public ModelAndView noticeWriteFrom(ModelAndView mv) {
			mv.addObject("board", "notice");
			mv.setViewName("board/boardWrite");
			return mv;
	}
	
	//관리자 공지사항 작성
	@PostMapping("insert.bo")
	public ModelAndView insertBoard(Board b,
									MultipartFile upfile,
									ModelAndView mv,
									HttpSession session) {

		

		if(!upfile.getOriginalFilename().equals("")) {//파일 업로드가 되었다면

			String changeName = saveFile(upfile,session);
			
			b.setOriginName(upfile.getOriginalFilename());
			b.setChangeName("resources/uploadFiles/"+changeName);
		}

		int result = boardService.insertBoard(b);
		
		if(result>0) { //성공시 - 게시판 리스트 띄워주기 (list.bo 재요청)
			session.setAttribute("alertMsg", "게시글이 등록되었습니다.");
			mv.setViewName("redirect:/list.bo");
		}else { //실패 - 에러페이지로 포워딩
			mv.addObject("errorMsg","게시글 등록 실패").setViewName("common/errorPage");
		}
			
		return mv;
	}
	
	//현재 넘어온 첨부파일을 서버 폴더에 저장시키는 메소드(모듈)
	public String saveFile(MultipartFile upfile,HttpSession session) {
		
		String originName = upfile.getOriginalFilename();
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String ext = originName.substring(originName.lastIndexOf("."));
		int ranNum = (int)(Math.random()*90000+10000);//5자리 랜덤값
		String changeName = currentTime + ranNum + ext;
		String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
		
		try {
			upfile.transferTo(new File(savePath+changeName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return changeName;

	}
	
		
	}
	


