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
import com.admin.board.model.vo.BoardType;
import com.common.model.vo.PageInfo;

/**
 * Servlet implementation class AdminBoardListViewController
 */
@WebServlet("/adminBoardView.bo")
public class BoardListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardListViewController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bt = request.getParameter("bt");
		if (bt==null) {
			bt = "%";
		}
		
		
		int listCount = new BoardService().countBoard(bt);

		ArrayList<BoardType> btList = new BoardService().selectBoardType();
		
		request.setAttribute("bt", bt);
		request.setAttribute("btList", btList);
		request.getRequestDispatcher(new AdminSupport().toBoardUrl("adminBoardListView")).forward(request, response);
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
