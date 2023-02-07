package com.user.board.recipe.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.common.JDBCTemplate;
import com.common.model.vo.Attachment;
import com.common.model.vo.PageInfo;
import com.user.board.recipe.model.dao.BoardDao;
import com.user.board.recipe.model.vo.Board;
import com.user.board.recipe.model.vo.DoseUnit;
import com.user.board.recipe.model.vo.Ingrd;
import com.user.board.recipe.model.vo.Recipe;
import com.user.board.recipe.model.vo.RecipeIngrd;

public class BoardService {

	// 게시글 수
	public int selectListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new BoardDao().selectListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
	
	// 레시피 리스트 불러오기
	public ArrayList<Board> selectRecipeList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Board> list = new BoardDao().selectRecipeList(conn,pi);
		
		return list;
	}

	public ArrayList<Board> searchRecipeList(PageInfo pi,String searchText) {
		
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Board> list = new BoardDao().searchRecipeList(conn,pi,searchText);
		
		return list;
	}

	public ArrayList<Ingrd> selectIngrdList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Ingrd> ingrdList = new BoardDao().selectIngrdList(conn);
		
		JDBCTemplate.close(conn);
		
		return ingrdList;
	}

	public ArrayList<DoseUnit> selectDoseUnitList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<DoseUnit> doseUnitList = new BoardDao().selectDoseUnitList(conn);
		
		JDBCTemplate.close(conn);
		
		return doseUnitList;
	}

	public int insertRecipeBoard(Board b, ArrayList<Recipe> rList, Attachment at,
								ArrayList<Attachment> atList, ArrayList<RecipeIngrd> riList) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().insertRecipeBoard(conn,b);
		int result2 = new BoardDao().insertRecipe(conn,rList);
		int result3 = new BoardDao().insertAttachment(conn,at);
		int result4 = new BoardDao().insertRecipeAttachment(conn,atList);
		int result5 = new BoardDao().insertIngrd(conn,riList);
		
		int finalresult = result*result2*result3*result4*result5;
		
		if(finalresult > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return finalresult;
	}

	public Board selectBoard(String bt, int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Board b = new BoardDao().selectBoard(conn, bt, bno);
		
		JDBCTemplate.close(conn);
		
		return b;
	}
	
	public ArrayList<Attachment> selectAttachmentList(String bt, int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Attachment> list = new BoardDao().selectAttachmentList(conn, bt, bno);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public ArrayList<Recipe> selectRecipeList(String bt, int bno) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Recipe> list = new BoardDao().selectRecipeList(conn, bt, bno);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<RecipeIngrd> selectRecipeIngrdList(String bt, int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<RecipeIngrd> list = new BoardDao().selectRecipeIngrdList(conn, bt, bno);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int increaseCount(int bno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().increaseCount(conn,bno);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	//이달의 베스트 레시피 불러오기 (1위부터 3위까지 좋아요가 많고 현재 기준 년월에 등록된 게시글만)
		public ArrayList<Board> bestMonthList() {
			
			Connection conn = JDBCTemplate.getConnection();
			
			ArrayList<Board> list = new BoardDao().bestMonthList(conn);
			
			//SELECT문 트랜젝션처리 X
			JDBCTemplate.close(conn);
			
			return list;
		}
	
	
}
