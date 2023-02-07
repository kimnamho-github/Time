package com.user.board.recipe.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.recipe.model.service.BoardService;
import com.user.board.recipe.model.vo.Board;


/**
 * Servlet implementation class AjaxBestMonthController
 */
@WebServlet("/list.mo")
public class BestMonthlyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BestMonthlyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Board> bestList = new BoardService().bestMonthList();
		
		//LocalDate객체를 이용하여 현재 시간 데이터를 가져오고
		//DateTimeFormatter 객체로 형식을 설정, .format메서드로 String자료형으로 변환
		//String의 substring을 이용해 년도와 월만 추출하고 포워딩해주자.
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String sysdate = now.format(formatter);
		String result = sysdate.substring(0, 7);
		
		request.setAttribute("now", result);
		request.setAttribute("bestList", bestList);
		
		request.getRequestDispatcher("/views/user/bestMonthlyListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
