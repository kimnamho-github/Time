package com.admin.board.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.admin.board.model.dao.BoardDao;
import com.admin.board.model.vo.Board;
import com.admin.board.model.vo.BoardType;
import com.admin.board.model.vo.Recipe;
import com.admin.board.model.vo.RecipeIngrd;
import com.common.JDBCTemplate;
import com.common.model.vo.Attachment;
import com.common.model.vo.PageInfo;

public class BoardService {

	public int countBoard(String bt) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().countBoard(conn,bt);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> selectBoardList(PageInfo pageInfo, String bt) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().selectBoardList(conn, pageInfo, bt);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<BoardType> selectBoardType() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<BoardType> list = new BoardDao().selectBoardType(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int countBoardSearch(String bt, String search) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().countBoardSearch(conn,bt,search);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> selectBoardSearch(PageInfo pageInfo, String bt, String search) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().selectBoardSearch(conn, pageInfo, bt, search);
		JDBCTemplate.close(conn);
		return list;
	}

	public int deleteBoard(ArrayList<Board> list) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().deleteBoard(conn, list);
		if (result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}


	public Board selectBoard(String bt, int bno) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		Board b = new BoardDao().selectBoard(conn, bt, bno);
		JDBCTemplate.close(conn);
		return b;
	}

	public int countBest() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().countBest(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> selectBestList(PageInfo pageInfo, String categoryCode) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().selectBestList(conn, pageInfo, categoryCode);
		JDBCTemplate.close(conn);
		return list;
	}

	public int deleteBest(ArrayList<Board> list) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().deleteBest(conn, list);
		if (result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Attachment> selectAttachmentList(String bt, int bno) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Attachment> list = new BoardDao().selectAttachmentList(conn, bt, bno);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Recipe> selectRecipeList(String bt, int bno) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Recipe> list = new BoardDao().selectRecipeList(conn, bt, bno);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<RecipeIngrd> selectRecipeIngrdList(String bt, int bno) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<RecipeIngrd> list = new BoardDao().selectRecipeIngrdList(conn, bt, bno);
		JDBCTemplate.close(conn);
		return list;
	}

	public int countBestSearch(String search) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().countBestSearch(conn,search);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> selectBestSearch(PageInfo pageInfo, String search,String categoryCode) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().selectBestSearch(conn,pageInfo, search,categoryCode);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertRecipeBoard(Board b, ArrayList<Recipe> rList, Attachment at, ArrayList<Attachment> atList,
			ArrayList<RecipeIngrd> riList) {
		// TODO Auto-generated method stub
		
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



}
