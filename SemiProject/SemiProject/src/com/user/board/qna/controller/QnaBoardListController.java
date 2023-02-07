package com.user.board.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.model.vo.PageInfo;
import com.user.board.qna.model.service.QnaBoardService;
import com.user.board.recipe.model.vo.Board;

/**
 * Servlet implementation class QnaBoardListView
 */
@WebServlet("/list.qa")
public class QnaBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaBoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount; 		//현재 게시판 게시글의 총 개수
		int currentPage;	//현재 페이지 (사용자가 요청한 페이지)
		
		int maxPage; 		//가장 마지막 페이지가 몇번페이지 인지 (총 페이지 수)
		int startPage; 		//페이지 하단에 보여질 페이징바의 시작수
		int endPage; 		//페이지 하단에 보여질 페이징바의 끝수
		
		//현재 Q&A 게시판 게시글의 총 개수를 반환
		listCount = new QnaBoardService().selectQnaListCount();
		
		//하단의 페이징 바를 클릭하면 사용자가 클릭해 요청한 페이지의 번호를 가져온다
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//1.페이징바를 만들기 위해 필요한 객체
		//은덕이가 만든 PageInfo 생성자를 이용해 두개의 데이터를 넘겨 객체 생성!(어려웡..)
		PageInfo pi = new PageInfo(listCount,currentPage);
		
		//2.현재 사용자가 요청한 Q&A페이지에 대해 보여질 게시글 리스트 조회하기
		ArrayList<Board> list = new QnaBoardService().selectQnaBoardList(pi);
	
		//Q&A게시판에 보여질 게시글 데이터와 pageInfo객체를 request영역에 올리자
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		//데이터를 해당 jsp파일로 포워딩해주자.
		request.getRequestDispatcher("/views/user/qnaBoardListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
