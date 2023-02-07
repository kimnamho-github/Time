package com.user.board.recipe.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.recipe.model.service.BoardService;
import com.user.board.recipe.model.vo.DoseUnit;
import com.user.board.recipe.model.vo.Ingrd;


/**
 * Servlet implementation class RecipeEnrollFormController
 */
@WebServlet("/enrollForm.re")
public class RecipeEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeEnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Ingrd> ingrdList = new BoardService().selectIngrdList();
		ArrayList<DoseUnit> doseUnitList = new BoardService().selectDoseUnitList();
		
		// 카테고리 테이블 정보 list에 담아오기
		request.setAttribute("ingrdList", ingrdList);
		request.setAttribute("doseUnitList", doseUnitList);
		
		request.getRequestDispatcher("/views/user/recipeEnrollForm.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
