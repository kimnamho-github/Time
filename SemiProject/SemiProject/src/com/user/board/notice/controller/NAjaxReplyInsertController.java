package com.user.board.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.member.model.vo.Member;
import com.user.board.notice.model.service.NoticeService;
import com.user.board.notice.model.vo.NReply;

/**
 * Servlet implementation class AjaxReplyInsertController
 */
@WebServlet("/rinsert.no")
public class NAjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String board_code;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NAjaxReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		int nno = Integer.parseInt(request.getParameter("nno"));
		String board_code = request.getParameter("board_code");
		String comments_content = request.getParameter("comments_content");
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		int MemberNo = loginUser.getMemberNo();

		NReply r = new NReply();
		r.setComments_content(content);
		r.setBoard_no(nno);
		r.setBoard_code(board_code);
		r.setComments_content(comments_content);
		r.setComments_writer(""+MemberNo);
		int result = new NoticeService().insertReply(r);
		
		response.getWriter().print(result);
	}

}
