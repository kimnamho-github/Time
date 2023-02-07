package com.admin.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.admin.member.model.service.MemberService;
import com.admin.member.model.vo.AdminMember;
import com.google.gson.Gson;

/**
 * Servlet implementation class AdminBoardListViewController
 */
@WebServlet("/adminMemberSelect.me")
public class MemberSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberSelectController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int mno = Integer.parseInt(request.getParameter("mno"));
		AdminMember m = new MemberService().selectMember(mno);
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(m,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
