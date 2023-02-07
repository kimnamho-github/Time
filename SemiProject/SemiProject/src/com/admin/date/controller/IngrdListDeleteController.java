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
import com.admin.date.model.dao.DateDao;
import com.admin.date.model.service.DateService;
import com.admin.date.model.vo.Ingrd;

/**
 * Servlet implementation class IngrdListDeleteController
 */
@WebServlet("/adminIngrdListDelete.da")
public class IngrdListDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngrdListDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] ino = request.getParameter("ino").split(",");
		HashMap<String, String> map =  new DateService().selectIngrd(ino);

		int result = new DateService().deleteIngrd(ino,map);

		if (result > 0 || ino.length==map.size()) {
			request.getSession().setAttribute(new AdminSupport().getAleatMsg(), ino.length+"개의 대이터 중에 "+map.values()+"를 제외한 "+(ino.length-map.size())+"의 데이터를 삭제했습니다.");
			response.sendRedirect("adminIngrdList.da?cPage=1");
		} else {
			request.setAttribute(new AdminSupport().getAleatMsg(), "데이터를 삭제하지 못했습니다.");
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
