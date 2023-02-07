package com.user.board.open.model.dao;

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
import com.user.board.open.model.vo.Board;
import com.user.board.open.model.vo.Comments;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	public BoardDao() {
		try {
			String filePath = BoardDao.class.getResource("/db/sql/user/open-board-mapper.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
 


	public int selectOpenListCount(Connection conn) {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOpenListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				//조회된 게시글 개수
				listCount = rset.getInt("COUNT");
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listCount;
	}



	public ArrayList<Board> selectOpenList(Connection conn, PageInfo pi) {
			
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectOpenList");

		//시작값 끝값 구하기 
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Board(rset.getInt("BOARD_NO")
								  ,rset.getString("BOARD_TITLE")
								  ,rset.getString("MEMBER_NAME")
								  ,rset.getInt("VIEWS")
								  ,rset.getDate("CREATED_DATE"))); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		
		return list;
		
	}





	public int insertOpenBoard(Connection conn, String memberNo, String boardTitle, String boardContent) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertOpenBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setString(3, memberNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	
	
	
	
	}


	//자유게시판 조회수 증가
	public int increaseOpenBoardCount(Connection conn, int openboardNo) {
		
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseOpenBoardCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, openboardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	public Board selectOpenBoard(Connection conn, int openboardNo) {

		ResultSet rset=null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOpenBoard");
		Board b = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, openboardNo);
		
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("BOARD_NO")
							  ,rset.getString("MEMBER_ID")
							  ,rset.getString("BOARD_TITLE")
							  ,rset.getString("BOARD_CONTENT")
							  ,rset.getInt("LIKES")
							  ,rset.getDate("CREATED_DATE"));
							  
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return b;
		
	
	}



	public int updateOpenBoard(Connection conn, Board b) {
		
		int result=0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateOpenBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3, b.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	public int deleteOpenBoard(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteOpenBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	public int insertComments(Connection conn, Comments c) {
		
		int result = 0;
		PreparedStatement pstmt=null;
		String sql = prop.getProperty("insertComments");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCommentsContent());
			pstmt.setInt(2, c.getBoardNo());
			pstmt.setInt(3, Integer.parseInt(c.getCommentsWriter()));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	public ArrayList<Comments> selectCommentsList(Connection conn, int ono) {
		
		ArrayList<Comments> list = new ArrayList<>();

		PreparedStatement pstmt=null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCommentsList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ono);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Comments(rset.getInt("COMMENTS_NO")
								  ,rset.getDate("CREATED_DATE")
								  ,rset.getString("COMMENTS_CONTENT")
								  ,rset.getString("MEMBER_ID"))); 
								 
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}


	
	

	public int deleteComments(Connection conn, int ono, int rno) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteComments");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	public int updateComments(Connection conn, int ono, int rno, String rc) {
		
		int result=0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateComments");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rc);
			pstmt.setInt(2, rno);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	public ArrayList<Board> selectMainList(Connection conn) {
		
		ArrayList<Board> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectMainList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("BOARD_NO"),
									rset.getString("MEMBER_NAME"),
									rset.getString("BOARD_TITLE"),
									rset.getInt("VIEWS"),
									rset.getInt("LIKES"),
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
	
	
	
	
	
	
	
	
	
	

