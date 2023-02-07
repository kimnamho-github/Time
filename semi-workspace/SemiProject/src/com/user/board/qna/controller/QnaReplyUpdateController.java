package com.user.board.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.qna.model.service.QnaBoardService;

/**
 * Servlet implementation class QnaReplyUpdateController
 */
@WebServlet("/reUpdate.qa")
public class QnaReplyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaReplyUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//댓글 수정시 입력받은 데이터도 인코딩..설정이 필요하겠죠?
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		int replyNo = Integer.parseInt(request.getParameter("rno"));
		String reContent = request.getParameter("reContent");
		
		System.out.println(boardNo);
		System.out.println(replyNo);
		System.out.println(reContent);
		
		int result = new QnaBoardService().updateQnaReply(boardNo,replyNo,reContent);
		
		response.getWriter().print(result);
	
	}

}
