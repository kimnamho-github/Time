package com.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.admin.AdminSupport;
import com.admin.member.model.service.MemberService;
import com.admin.member.model.vo.AdminMember;

/**
 * Servlet implementation class AdminBoardListViewController
 */
@WebServlet("/adminMemberUpdate.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateController() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String mno = request.getParameter("mno");
		String grade = request.getParameter("grade");
		grade = grade==null?"M1":grade;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		AdminMember m = new AdminMember();
		m.setMemberNo(Integer.parseInt(mno));
		m.setGradeCode(grade);
		m.setMemberId(id);
		m.setMemberPwd(pwd);
		m.setMemberName(name);
		m.setPhone(phone);
		m.setEmail(email);
		m.setAddress(address);
		int result = new MemberService().updateMember(m);
		if (result > 0 ) {
			request.getSession().setAttribute(new AdminSupport().getAleatMsg(), "회원정보가 수정되었니다.");
			response.sendRedirect("adminMemberView.me");
		} else {
			request.getSession().setAttribute(new AdminSupport().getAleatMsg(), "회원정보를 수정하지 못했습니다.");
			request.getRequestDispatcher(new AdminSupport().toCommonUrl("errorPage")).forward(request, response);
		}
		
	}

}
