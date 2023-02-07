package com.user.board.recipe.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.model.vo.PageInfo;
import com.user.board.recipe.model.service.BoardService;
import com.user.board.recipe.model.vo.Board;

/**
 * Servlet implementation class RecipeBoardListController
 */
@WebServlet("/list.re")
public class RecipeBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeBoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount; // 현재 총 게시글 개수
		int currentPage; // 현재 페이지(즉,사용자가 요청한 페이지)
		int boardLimit = 9; // 한 페이지에 보여질 게시글의 최대 개수
		
		listCount = new BoardService().selectListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		PageInfo pi = new PageInfo(listCount,currentPage,boardLimit);
		
		ArrayList<Board> list = new BoardService().selectRecipeList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/user/recipeBoardListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
