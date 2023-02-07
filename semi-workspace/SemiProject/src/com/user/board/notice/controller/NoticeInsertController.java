package com.user.board.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.in")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		String MemberNo = request.getParameter("nno");		
		String title  = request.getParameter("title");
		String content = request.getParameter("content");
		
		int result = new NoticeService().insertNotice(MemberNo,title,content);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "공지사항 등록 완료");
			response.sendRedirect(request.getContextPath()+"/list.in");
		}else {
			request.setAttribute("errorMsg", "공지사항 등록 실패");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);			
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
