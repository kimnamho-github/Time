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
@WebServlet("/adminDoseInsert.da")
public class DoseInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoseInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dname = request.getParameter("dname");

		int result = new DateService().inertDose(dname);

		if (result > 0 ) {
			request.getSession().setAttribute(new AdminSupport().getAleatMsg(), dname+"의 데이터가 추가되었습니다.");
			response.sendRedirect("adminDoseList.da?cPage=1");
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
