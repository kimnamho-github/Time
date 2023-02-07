package com.admin.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.admin.member.model.service.MemberService;
import com.admin.member.model.vo.AdminMember;
import com.admin.member.model.vo.MemberGrade;
import com.common.model.vo.PageInfo;

/**
 * Servlet implementation class AdminBoardListViewController
 */
@WebServlet("/adminMemberView.me")
public class MemberListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberListViewController() {
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
		String cPage = request.getParameter("cPage");
		String search = request.getParameter("search");
		String mg = request.getParameter("mg");
		mg = mg == null ? "%" : mg;
		search = search == null? "%" : search;
		int currentPage = Integer.parseInt(cPage == null ? "1" : cPage);
		int listCount = new MemberService().countMember(search, mg);
		PageInfo pageInfo = new PageInfo(listCount, currentPage, 10);
		ArrayList<AdminMember> mList = new MemberService().selectMemberList(pageInfo, search, mg);
		ArrayList<MemberGrade> mgList = new MemberService().selectMemberGrade();
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("mList", mList);
		request.setAttribute("mgList", mgList);
		request.setAttribute("search", search);
		request.setAttribute("mg", mg);
		request.getRequestDispatcher("/views/admin/member/adminMemberListView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
