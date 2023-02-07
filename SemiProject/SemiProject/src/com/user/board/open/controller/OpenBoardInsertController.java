package com.user.board.open.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.open.model.service.BoardService;


/**
 * Servlet implementation class OpenBoardInsertController
 */
@WebServlet("/insert.op")
public class OpenBoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenBoardInsertController() {
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
		
		String MemberNo = request.getParameter("MemberNo");
		String boardTitle = request.getParameter("op-title");
		String boardContent = request.getParameter("op-content");
		
		
		int result = new BoardService().insertOpenBoard(MemberNo,boardTitle,boardContent);
		
		if(result>0) {
			 request.getSession().setAttribute("alertMsg", "게시글 등록이 완료되었습니다.");
			 response.sendRedirect(request.getContextPath()+"/list.op?currentPage=1");
		 }else {
			  request.setAttribute("errorPage", "게시글 작성 실패 하하 :");
			  request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		
		 }
		
		 
		
	}

	
}





