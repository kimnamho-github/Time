package com.user.board.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.qna.model.service.QnaBoardService;

/**
 * Servlet implementation class QnaDeleteController
 */
@WebServlet("/delete.qa")
public class QnaDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//쿼리스트링 ?bno= 뒤에 붙어 넘어온 게시판 번호
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//Q&A게시판 글 삭제 메서드
		int result = new QnaBoardService().deleteQna(bno);
		
		if(result!=0) {
			request.setAttribute("alertMsg", "게시글 삭제가 완료되었습니다!");
			response.sendRedirect(request.getContextPath()+"/list.qa?currentPage=1");
		}else {
			request.setAttribute("errorMsg", "게시글 삭제를 실패했습니다...");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
