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
 * Servlet implementation class OpenBoardUpdateFormController
 */
@WebServlet("/updateForm.op")
public class OpenBoardUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenBoardUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardService bService = new BoardService();
	
		int openboardNo = Integer.parseInt(request.getParameter("ono"));
		
		Board b = bService.selectOpenBoard(openboardNo);
		
		request.setAttribute("b", b);
		request.getRequestDispatcher("/views/user/openBoardUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
