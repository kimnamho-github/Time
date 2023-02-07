package com.user.board.open.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.model.vo.PageInfo;
import com.google.gson.Gson;
import com.user.board.open.model.service.BoardService;
import com.user.board.open.model.vo.Board;

/**
 * Servlet implementation class OpenBoardController
 */
@WebServlet("/list.op")
public class OpenBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenBoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		
		
		int listCount; // 현재 총 게시글 개수
		int currentPage; // 현재 페이지(즉,사용자가 요청한 페이지)
		int boardLimit; //한 페이지에 보여질 게시글의 최대 개수(몇개 단위씩 보여질건지)
		
		boardLimit = 9;
		
		listCount = new BoardService().selectOpenListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		
		PageInfo pi = new PageInfo(listCount,currentPage);
		
		ArrayList<Board> list = new BoardService().selectOpenList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		
		request.getRequestDispatcher("/views/user/openBoardListView.jsp").forward(request, response);
	 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
