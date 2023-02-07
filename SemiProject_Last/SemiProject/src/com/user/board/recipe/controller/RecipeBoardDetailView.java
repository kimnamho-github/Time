package com.user.board.recipe.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.model.vo.Attachment;
import com.user.board.recipe.model.service.BoardService;
import com.user.board.recipe.model.vo.Board;
import com.user.board.recipe.model.vo.Recipe;
import com.user.board.recipe.model.vo.RecipeIngrd;

/**
 * Servlet implementation class RecipeBoardDetailView
 */
@WebServlet("/detail.re")
public class RecipeBoardDetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeBoardDetailView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bt = "B3";
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		int result = new BoardService().increaseCount(bno);
		
		if(result > 0) {
			Board b = new BoardService().selectBoard(bt, bno);
			
			if (b != null) {
				
				ArrayList<Attachment> at = new BoardService().selectAttachmentList(bt, bno);
				ArrayList<Recipe> recipe = new BoardService().selectRecipeList(bt, bno);
				ArrayList<RecipeIngrd> ingrd = new BoardService().selectRecipeIngrdList(bt, bno);
				
				request.setAttribute("b", b);
				request.setAttribute("at", at);
				request.setAttribute("recipe", recipe);
				request.setAttribute("ingrd", ingrd);
				
				request.getRequestDispatcher("/views/user/recipeDetailView.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMsg", "게시글을 조회할 수 없습니다.");
				request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
			}
			
		}else {
			request.setAttribute("errorMsg", "게시글을 조회할 수 없습니다.");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
