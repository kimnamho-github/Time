package com.user.board.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.model.vo.PageInfo;
import com.user.board.notice.model.service.NoticeService;
import com.user.board.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListController
 */
@WebServlet("/list.in")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount = new NoticeService().selectListCount();	
		
		String str = request.getParameter("currentPage");
		
		int currentPage = 0;
		if (str==null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(str);
		}
		
		PageInfo pageInfo = new PageInfo(listCount, currentPage);	
		pageInfo.startBoard();
		pageInfo.endBoard();
		
		ArrayList<Notice> nlist = new NoticeService().selectList(pageInfo);
	
		request.setAttribute("nlist", nlist);
		
		request.setAttribute("pageInfo", pageInfo);
		
		
		
		request.getRequestDispatcher("/views/user/noticeListView.jsp").forward(request, response);
		
		
		
		
		
		
//		ArrayList<Notice> list = new NoticeService().selectNoticeList();
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("/views/notice/noticeListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
