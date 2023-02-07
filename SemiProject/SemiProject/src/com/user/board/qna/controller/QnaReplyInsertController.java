package com.user.board.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.open.model.vo.Comments;
import com.user.board.qna.model.service.QnaBoardService;
import com.user.member.model.vo.Member;

/**
 * Servlet implementation class QnaReplyInsertController
 */
@WebServlet("/reInsert.qa")
public class QnaReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaReplyInsertController() {
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
		
		request.setCharacterEncoding("UTF-8");
	
		//사용자가 댓글을 입력한 게시글의 번호를 사용해 게시글과 댓글을 연결시켜주자 (수업시간엔 참조게시글번호로 넣어주었다)
		int bno = Integer.parseInt(request.getParameter("bno")); // 사용자가 댓글 입력한 게시글 번호
		String reContent = request.getParameter("content"); // 사용자가 입력한 댓글 내용
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser"); // Object타입이라 형변환 필요
		String memberNo = String.valueOf(loginUser.getMemberNo()); // 로그인 유저의 번호			
		
		//Comments객체 생성하여 데이터를 담아 들고가자
		Comments cm = new Comments();
		cm.setBoardNo(bno);	
		cm.setCommentsContent(reContent);
		cm.setCommentsWriter(memberNo);
		
		//Q&A게시판 댓글 등록 메서드
		int result = new QnaBoardService().insertQnaReply(cm);
		
		//qnaBoardDetailForm.jsp로 데이터 보내기
		//데이터가 하나이기 때문에 JSON사용
		response.getWriter().print(result);
		
	}

}
