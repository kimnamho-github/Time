package com.admin.date.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.AdminSupport;
import com.admin.board.model.service.BoardService;
import com.admin.board.model.vo.Board;
import com.admin.date.model.service.DateService;
import com.google.gson.Gson;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/adminIngrdInsert.da")
public class IngrdInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngrdInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String iname = request.getParameter("iname");

		int result = new DateService().inertIngrd(iname);

		if (result > 0 ) {
			request.getSession().setAttribute(new AdminSupport().getAleatMsg(), iname+"의 데이터가 추가되었니다.");
			response.sendRedirect("adminIngrdList.da?cPage=1");
		} else {
			request.setAttribute(new AdminSupport().getAleatMsg(), "데이터를 추가하지 못했습니다.");
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
