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
 * Servlet implementation class OpenBoardDetailController
 */
@WebServlet("/detail.op")
public class OpenBoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenBoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int openboardNo = Integer.parseInt(request.getParameter("ono")); 
		
		int result = new BoardService().increaseOpenBoardCount(openboardNo);
		
	
		if(result>0) {
			
			Board b = new BoardService().selectOpenBoard(openboardNo);
			
			request.setAttribute("b", b);
			request.getRequestDispatcher("/views/user/openBoardDetailView.jsp").forward(request, response);
			
			
		}else {
			//실패햇으니 에러페이지
			request.setAttribute("errorMsg", "조회가 정상적으로 수행되지 못하였습니다. ");
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
