package com.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.admin.AdminSupport;
import com.admin.member.model.service.MemberService;

/**
 * Servlet implementation class IngrdListDeleteController
 */
@WebServlet("/adminMemberListDelete.me")
public class MemberListDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] mno = request.getParameter("mno").split(",");

		int result = new MemberService().deleteMember(mno);

		if (result > 0 ) {
			request.getSession().setAttribute(new AdminSupport().getAleatMsg(), mno.length+"명의 회원을 탈퇴했습니다.");
			response.sendRedirect(request.getContextPath()+"/adminMemberView.me");
		} else {
			request.setAttribute(new AdminSupport().getAleatMsg(), "회원을 탈퇴시키지 못했습니다.");
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
