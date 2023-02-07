package com.user.board.open.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.open.model.service.BoardService;
import com.user.board.open.model.vo.Board;


/**
 * Servlet implementation class OpenBoardUpdateController
 */
@WebServlet("/update.op")
public class OpenBoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenBoardUpdateController() {
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
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("op-title");
		String boardContent = request.getParameter("op-content");
		
		Board b = new Board();
		b.setBoardNo(boardNo);
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		
		int result = new BoardService().updateOpenBoard(b); 
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "게시글 수정이 완료되었습니다.");
			response.sendRedirect(request.getContextPath()+"/detail.op?ono="+boardNo);
		}else {
			request.setAttribute("errorMsg", "게시글 수정 실패");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		}
	
	
	}

}
