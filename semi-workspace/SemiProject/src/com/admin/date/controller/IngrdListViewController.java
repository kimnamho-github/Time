package com.admin.date.controller;

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
import com.admin.date.model.service.DateService;
import com.admin.date.model.vo.Ingrd;
import com.common.model.vo.PageInfo;

/**
 * Servlet implementation class AdminBoardListViewController
 */
@WebServlet("/adminIngrdList.da")
public class IngrdListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IngrdListViewController() {
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
		String cPage = request.getParameter("cPage");
		String search = request.getParameter("search");
		int currentPage = Integer.parseInt(cPage == null ? "1" : cPage);
		int listCount = new DateService().countIngrd(search);
		PageInfo pageInfo = new PageInfo(listCount, currentPage, 20);
		ArrayList<Ingrd> list = new DateService().selectIngrdList(pageInfo,search);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("list", list);
		request.setAttribute("search", search);
		
		request.getRequestDispatcher("/views/admin/data/adminIngrdListView.jsp").forward(request, response);

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
