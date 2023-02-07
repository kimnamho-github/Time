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
import com.admin.board.model.vo.Recipe;
import com.admin.board.model.vo.RecipeIngrd;
import com.common.model.vo.Attachment;
import com.user.board.qna.model.service.QnaBoardService;

/**
 * Servlet implementation class BoardDetailViewController
 */
@WebServlet("/adminBoardDetail.bo")
public class BoardDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bt = request.getParameter("bt");
		int bno = Integer.parseInt(request.getParameter("bno"));
		Board b = new BoardService().selectBoard(bt, bno);
		if (b!=null) {
			String url = "";
			request.setAttribute("b", b);
			request.setAttribute("bt", bt);
			if (bt.equals("B4")||bt.equals("B1")) {
					url = new AdminSupport().toBoardUrl("adminBoardDetailView");
			}else if(bt.equals("B2")||bt.equals("B3")) {
				ArrayList<Attachment> at = new BoardService().selectAttachmentList(bt,bno);
				ArrayList<Recipe> recipe = new BoardService().selectRecipeList(bt,bno);
				ArrayList<RecipeIngrd> ingrd = new BoardService().selectRecipeIngrdList(bt,bno);
				request.setAttribute("at", at);
				request.setAttribute("recipe", recipe);
				request.setAttribute("ingrd", ingrd);
				url = new AdminSupport().toBoardUrl("adminRecipeDetailView");
			}else {
				url = "/detail.qa?bno="+bno;
			}
			request.getRequestDispatcher(url).forward(request, response);
		}else {
			request.setAttribute("errorMsg", "게시글을 조회할 수 없습니다.");
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
