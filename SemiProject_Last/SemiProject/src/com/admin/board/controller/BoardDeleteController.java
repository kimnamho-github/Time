package com.admin.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.AdminSupport;
import com.admin.board.model.service.BoardService;
import com.admin.board.model.vo.Board;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/adminBoardDelete.bo")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bt = request.getParameter("bt");
		String bno = request.getParameter("bno");
		
		Board b = new Board();
		b.setBoardNo(Integer.parseInt(bno));
		b.setBoardCode(bt);
		ArrayList<Board> list = new ArrayList<Board>();
		list.add(b);
		int result = new BoardService().deleteBoard(list);
		if (result > 0) {
			request.getSession().setAttribute(new AdminSupport().getAleatMsg(), "게시글을 삭제했습니다.");
			response.sendRedirect("adminBoardView.bo?cPage=1");
		} else {
			request.setAttribute(new AdminSupport().getAleatMsg(), "게시글을 삭제하지 못했습니다.");
			request.getRequestDispatcher(new AdminSupport().toCommonUrl("errorPage")).forward(request, response);
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
