package com.user.board.open.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.open.model.service.BoardService;
import com.user.board.open.model.vo.Comments;
import com.user.member.model.vo.Member;

/**
 * Servlet implementation class AjaxReplyInsertController
 */
@WebServlet("/rinsert.op")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertController() {
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
		int ono = Integer.parseInt(request.getParameter("ono"));
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		int memberNo = loginUser.getMemberNo();
		
		
		Comments c = new Comments();
	
		c.setCommentsContent(content);
		c.setBoardNo(ono); 
		c.setCommentsWriter(String.valueOf(memberNo));
		
		int result = new BoardService().insertComments(c);
		
		response.getWriter().print(result);
	
	}

}
