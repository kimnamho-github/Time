package com.user.board.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.user.board.open.model.vo.Comments;
import com.user.board.qna.model.service.QnaBoardService;

/**
 * Servlet implementation class QnaReplyListController
 */
@WebServlet("/reList.qa")
public class QnaReplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaReplyListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//parameter영역에서 받아왔으니 언박싱
		int bno = Integer.parseInt(request.getParameter("bno")); // 댓글이 작성된 게시글 번호
		
		//Q&A게시판 게시글 작성 댓글 내용 가져오기
		ArrayList<Comments> reList = new QnaBoardService().selectReplyList(bno);
		
		//ArrayList객체 배열을 보내줘야하기 때문에 Gson을 사용한다.
		//인코딩설정을 해서 보내주자
		response.setContentType("aplication/json; charset=UTF-8");
		new Gson().toJson(reList,response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
