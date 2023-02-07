package com.user.board.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.board.qna.model.service.QnaBoardService;

/**
 * Servlet implementation class QnaUpdateController
 */
@WebServlet("/update.qa")
public class QnaUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaUpdateController() {
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
		
		int bno = Integer.parseInt(request.getParameter("boardNo")); //게시글 번호
		String title = request.getParameter("title"); // 게시글 제목
		String content = request.getParameter("content"); // 게시글 내용
		//textarea 내용의 개행을 위해 엔터값을 개행문자로 처리하자
		content = content.replace("\r\n", "<br>");
		
		//사용자가 등록한 질문 게시글을 수정하는 메서드
		int result = new QnaBoardService().updateQnaBoard(bno, title, content);
		
		if(result != 0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "게시글 수정이 완료되었습니다!");
			response.sendRedirect(request.getContextPath()+"/list.qa?currentPage=1");
		}else {
			request.setAttribute("errorMsg", "게시글 수정이 실패했습니다");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		}
		
	}

}
