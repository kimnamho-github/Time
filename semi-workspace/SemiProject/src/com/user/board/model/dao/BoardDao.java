package com.user.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.common.JDBCTemplate;
import com.common.model.vo.PageInfo;
import com.user.board.model.vo.Board;

public class BoardDao {

	private Properties prop = new Properties();
	
	public BoardDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(BoardDao.class.getResource("/db/sql/user/recipe-board-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// 게시글 수
	public int selectListCount(Connection conn) {
		// select문
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				// 조회된 게시글 개수
				listCount = rset.getInt("COUNT");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listCount;
	}
	
	// 레시피 리스트 불러오기
	public ArrayList<Board> selectRecipeList(Connection conn, PageInfo pi) {
		
		ArrayList<Board> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectRecipeList");
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getString("MEMBER_NAME"),
									rset.getString("BOARD_TITLE"),
									rset.getInt("LIKES"),
									rset.getInt("VIEWS"),
									rset.getString("TITLEIMG")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int insertRecipe(Connection conn, String recipeTitle, String recipeContent, String recipeTitleImg) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return result;
	}

	public ArrayList<Board> searchRecipeList(Connection conn, PageInfo pi, String searchText) {
		
		ArrayList<Board> list= new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("searchRecipeList");
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchText);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getString("MEMBER_NAME"),
									rset.getString("BOARD_TITLE"),
									rset.getInt("LIKES"),
									rset.getInt("VIEWS"),
									rset.getString("TITLEIMG")
									));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return list;
	}

	
	
	
	
	
}
