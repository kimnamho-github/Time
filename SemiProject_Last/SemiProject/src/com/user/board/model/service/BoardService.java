package com.user.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.common.JDBCTemplate;
import com.common.model.vo.PageInfo;
import com.user.board.model.dao.BoardDao;
import com.user.board.model.vo.Board;

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

	public int insertRecipe(String recipeTitle, String recipeContent, String recipeTitleImg) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().insertRecipe(conn,recipeTitle,recipeContent,recipeTitleImg);
		
		return result;
	}

	public ArrayList<Board> searchRecipeList(PageInfo pi,String searchText) {
		
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Board> list = new BoardDao().searchRecipeList(conn,pi,searchText);
		
		return list;
	}

	

	

	
	
	
	
	
}
