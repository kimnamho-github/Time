package com.user.board.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.qna.model.service.QnaBoardService;

/**
 * Servlet implementation class QnaInsertController
 */
@WebServlet("/insert.qa")
public class QnaInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaInsertController() {
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
		
		//사용자가 입력한 데이터를 사용하기 위해 인코딩 설정을 해준다.
		request.setCharacterEncoding("UTF-8");
		
		//사용자가 입력한 데이터를 변수에 담아주자. name이 key
		String memberNo = request.getParameter("memberNo"); // 사용자 번호
		String title = request.getParameter("title"); // 게시글 제목
		String content = request.getParameter("content"); // 게시글 내용
		//textarea 내용의 개행을 위해 엔터값을 개행문자로 처리하자
		content = content.replace("\r\n", "<br>");
		
		//Q&A게시판 게시글 수정내용 업데이트 메서드
		int result = new QnaBoardService().insertQnaBoard(memberNo,title,content);
		
		if(result != 0) {
			//등록이 성공하면 menubar.jsp에 선언해놓은 alertMsg가 작동하도록 session에 올려주자
			request.getSession().setAttribute("alertMsg", "게시글 등록이 성공했습니다.");
			response.sendRedirect(request.getContextPath()+"/list.qa?currentPage=1");
		}else {
			request.setAttribute("errorPage", "게시글 등록 실패!");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		}

	}

}
