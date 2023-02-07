package com.user.board.recipe.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyFileRenamePolicy;
import com.common.model.vo.Attachment;
import com.oreilly.servlet.MultipartRequest;
import com.user.board.recipe.model.service.BoardService;
import com.user.board.recipe.model.vo.Board;
import com.user.board.recipe.model.vo.Recipe;
import com.user.board.recipe.model.vo.RecipeIngrd;

/**
 * Servlet implementation class RecipeInsertController
 */
@WebServlet("/insert.re")
public class RecipeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeInsertController() {
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
		
		request.setCharacterEncoding("UTF-8");
		
		// 폼 전송을 일반 방식이 아니라 multipart/form-data 로 전송하는 경우
		// request로부터 값을 뽑을 수 없다.
		// multipart라는 객체에 담아서 사용해야 한다.
		
		// enctype이 multipart/form-data로 전송되었는지 확인하는 작업
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 1. 전송되는 파일을 처리할 작업 내용(전송되는 파일의 용량제한,전달된 파일을 저장할 경로)
			// 1_1. 전송파일 용량 제한 (int maxSize = byte단위의 값을 기술하여 제한한다.)	
			int maxSize = 10 * 1024 * 1024; // 10mbyte로 지정
			
			// 1_2. 전달된 파일을 저장할 서버의 경로를 알아내기
			String savePath = request.getSession().getServletContext().getRealPath("/resources/image/recipeImg/");
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			// 3. DB에 기록할 데이터들을 뽑아서 Attachment 객체에 담기
			// -카테고리 번호,제목,내용,작성자 회원번호를 뽑아 Board테이블에 insert 해야하고
			// -만약 넘어온 첨부파일이 있다면 원본명,수정명,폴더 경로를 뽑아서 Attachment 테이블에 insert 해야한다.
			
			// BOARD_WRITER, BOARD_TITLE, BOARD_CONTENT 게시글
			// ORDER_NO,RECIPE_CONTENT 조리내용
			// REF_CNO,ORIGIN_NAME,CHANGE_NAME 파일 경로
			// INGRD_CODE,DOSE,DOSE_CODE 레시피 재료
			
			// 게시글
			String boardWriter = multiRequest.getParameter("boardWriter");
			String boardTitle = multiRequest.getParameter("boardTitle");
			String boardContent = multiRequest.getParameter("boardContent");
			
			Board b = new Board();
			b.setBoardWriter(boardWriter);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
			
			// 조리내용
			Recipe r = null;
			ArrayList<Recipe> rList = new ArrayList<>();

			// 조리내용 최대 10개
			for(int i = 1; i <= 10; i++) {
				
				String orderKey = "orderNo" + i;
				String rContentKey = "recipeContent" + i;
				
				if(multiRequest.getParameter("orderNo" + i) != null) {
					r = new Recipe();
					r.setOrderNo(Integer.parseInt(multiRequest.getParameter(orderKey)));
					r.setRecipeContent(multiRequest.getParameter(rContentKey));
					
					rList.add(r);
				}
			}
			
			// 레시피 재료
			RecipeIngrd ri= null;
			ArrayList<RecipeIngrd> riList = new ArrayList<>();
			
			// 재료 최대 20개
			for(int i = 1; i <= 20; i++) {
				
				String ingrdCodeKey = "ingrdCode" + i;
				String doseKey = "dose" + i;
				String doseCodeKey = "doseCode" + i;
				
				if(multiRequest.getParameter("ingrdCode" + i) != null) {
					ri = new RecipeIngrd();
					ri.setIngrdCode(multiRequest.getParameter(ingrdCodeKey));
					ri.setDose(multiRequest.getParameter(doseKey));
					ri.setDoseCode(multiRequest.getParameter(doseCodeKey));
					
					riList.add(ri);
				}
			}
			
			// 파일 경로
			Attachment at = null; // 처음에는 null로 초기화, 첨부파일이 있을수도 없을수도 있기 때문에 있다면 그때 객체 생성해서 전달
			
			if(multiRequest.getOriginalFileName("titleImg") != null) {
				// 첨부파일이 있는 경우
				at = new Attachment();
				
				at.setRefCno(Integer.parseInt(multiRequest.getParameter("refCno1")));
				at.setOriginName(multiRequest.getOriginalFileName("titleImg")); // 원본명
				at.setChangeName(multiRequest.getFilesystemName("titleImg")); // 실제 서버에 업로드되어있는 파일명
				at.setFilePath("/resources/image/recipeImg/");
			}
			
			Attachment at2 = null;
			
			ArrayList<Attachment> atList = new ArrayList<>();
			
			for(int i = 1; i <= 10; i++) { // name값이 file1,file2,file3,file4 이기 때문에 인덱스를 활용해서 키값 활용
				
				// 키값
				String refCnokey = "refCno" + (i+1);
				String recipImgKey = "recipImg" + i;
				
				// 키값에 해당하는 input file요소에 넘어온 파일이 있는지(파일이름이 있는지)
				if(multiRequest.getParameter(refCnokey) != null) {
					// 첨부파일이 있으면
					// Attachment 객체를 생성해서 데이터 담고 list에 추가하기
					at2 = new Attachment();
					
					at2.setRefCno(Integer.parseInt(multiRequest.getParameter(refCnokey)));
					at2.setOriginName(multiRequest.getOriginalFileName(recipImgKey));
					at2.setChangeName(multiRequest.getFilesystemName(recipImgKey));
					at2.setFilePath("/resources/image/recipeImg/");
					
					// at 객체 데이터 세팅이 끝났으니 list에 추가해주기
					atList.add(at2);
				}
				
			}
			
			// 4. 서비스 요청
			int result = new BoardService().insertRecipeBoard(b,rList,at,atList,riList);
			
			if(result > 0) {
				// 성공시 사진게시판 목록 띄워주기
				request.getSession().setAttribute("alertMsg", "사진게시글 작성 성공");
				request.getSession().setAttribute("board", b);
				request.getSession().setAttribute("rList", rList);
				request.getSession().setAttribute("titleImg", at);
				request.getSession().setAttribute("contentImg", atList);
				request.getSession().setAttribute("riList", riList);
				
				response.sendRedirect(request.getContextPath()+"/list.re?currentPage=1");
			}else {
				// 실패시 에러페이지
				request.setAttribute("errorMsg", "사진게시글 작성 실패");
				request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
			}
			
		}
		
		
	}

}
