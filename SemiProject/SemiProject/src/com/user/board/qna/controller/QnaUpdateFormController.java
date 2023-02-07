package com.user.board.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.qna.model.service.QnaBoardService;
import com.user.board.recipe.model.vo.Board;

/**
 * Servlet implementation class QnaBoardUpdateController
 */
@WebServlet("/updateForm.qa")
public class QnaUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Parameter영역의 값은 String으로 넘어오기 때문에 언박싱해준다.
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//사용자가 작성한 질문게시글의 데이터
		Board qnaList = new QnaBoardService().updateQnaForm(bno); // 게시글 번호
		
		if(qnaList != null) {
			request.setAttribute("qnaList", qnaList);
			request.getRequestDispatcher("/views/user/qnaUpdateForm.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "게시글을 찾을 수 없습니다");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
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
