package com.user.board.open.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.open.model.service.BoardService;


/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/delete.op")
public class OpenBoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenBoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("ono"));
		
		int result = new BoardService().deleteOpenBoard(boardNo);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "게시글 삭제가 완료되었습니다.");
			response.sendRedirect(request.getContextPath()+"/list.op?currentPage=1"); 
		}else {
			request.setAttribute("errorMsg", "게시글 삭제가 실패하였습니다.");
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
