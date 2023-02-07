package com.admin.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import com.admin.AdminSupport;
import com.admin.board.model.vo.Board;
import com.admin.board.model.vo.BoardType;
import com.admin.board.model.vo.Recipe;
import com.admin.board.model.vo.RecipeIngrd;
import com.common.JDBCTemplate;
import com.common.model.vo.Attachment;
import com.common.model.vo.PageInfo;

public class BoardDao {
	private Properties prop = new Properties();

	public BoardDao() {
		String filePath = BoardDao.class.getResource(new AdminSupport().toXmlUrl("board")).getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public int countBoard(Connection conn, String bt) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sql = prop.getProperty("countBoard");
		if (bt!=null) {
			sql += prop.getProperty("likeBoardTitle");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			if (bt!=null) {
				pstmt.setString(1, bt);
			}
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectBoardList(Connection conn, PageInfo pageInfo, String bt) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardListStart");
		if (bt!=null) {
			sql += prop.getProperty("likeBoardCode");
		}
		sql += prop.getProperty("orderCreatedDate")
				+prop.getProperty("orderDesc")
				+prop.getProperty("selectBoardListEnd");
		
		try {		
			pstmt = conn.prepareStatement(sql);

			if (bt!=null) {
				pstmt.setString(1, bt);
				pstmt.setInt(2, pageInfo.startBoard());
				pstmt.setInt(3, pageInfo.endBoard());
			}else {
				pstmt.setInt(1, pageInfo.startBoard());
				pstmt.setInt(2, pageInfo.endBoard());
			}
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Board board = new Board();
				board.setRowNum(rset.getInt("RNUM"));
				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setCreatedDate(rset.getDate("CREATED_DATE"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardWriter(rset.getString("MEMBER_ID"));
				board.setViews(rset.getInt("VIEWS"));
				board.setBoardCode(rset.getString("BOARD_CODE"));
				board.setBoardName(rset.getString("BOARD_KOR_NAME"));
				board.setLikes(rset.getInt("LIKES"));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<BoardType> selectBoardType(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<BoardType> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardType")
				+prop.getProperty("orderBoardCode");
		try {			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				BoardType boardType = new BoardType();
				boardType.setBoardCode(rset.getString("BOARD_CODE"));
				boardType.setBoardKorName(rset.getString("BOARD_KOR_NAME"));
				boardType.setBoardName(rset.getString("BOARD_NAME"));
				list.add(boardType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int countBoardSearch(Connection conn, String bt, String search) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sql = prop.getProperty("countBoard")
				+prop.getProperty("likeBoardCode")
				+prop.getProperty("likeBoardTitle");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bt);
			pstmt.setString(2, search);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectBoardSearch(Connection conn, PageInfo pageInfo, String bt, String search) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoardListStart")
				+prop.getProperty("likeBoardCode")
				+prop.getProperty("likeBoardTitle")
				+prop.getProperty("orderCreatedDate")
				+prop.getProperty("orderDesc")
				+prop.getProperty("selectBoardListEnd");
		
		try {		
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bt);
			pstmt.setString(2, search);
			pstmt.setInt(3, pageInfo.startBoard());
			pstmt.setInt(4, pageInfo.endBoard());
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Board board = new Board();
				board.setRowNum(rset.getInt("RNUM"));
				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setCreatedDate(rset.getDate("CREATED_DATE"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardWriter(rset.getString("MEMBER_ID"));
				board.setViews(rset.getInt("VIEWS"));
				board.setBoardCode(rset.getString("BOARD_CODE"));
				board.setBoardName(rset.getString("BOARD_KOR_NAME"));
				board.setLikes(rset.getInt("LIKES"));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int deleteBoard(Connection conn, ArrayList<Board> list) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("deleteBoard");
		
		try {		
			pstmt = conn.prepareStatement(sql);
			for (Board b : list) {
				pstmt.setInt(1, b.getBoardNo());
				pstmt.setString(2, b.getBoardCode());
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Board selectBoard(Connection conn, String bt, int bno) {
		// TODO Auto-generated method stub
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {		
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bt);
			pstmt.setInt(2, bno);
			
			rset = pstmt.executeQuery();
			if (rset.next()) {
				b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardCode(rset.getString("BOARD_KOR_NAME"));
				b.setBoardWriter(rset.getString("MEMBER_ID"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContent(rset.getString("BOARD_CONTENT"));
				b.setViews(rset.getInt("VIEWS"));
				b.setLikes(rset.getInt("LIKES"));
				b.setCreatedDate(rset.getDate("CREATED_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return b;
	}

	public int countBest(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sql = prop.getProperty("countBest");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectBestList(Connection conn, PageInfo pageInfo, String categoryCode) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "";
		if (categoryCode.equals("VIEWS")) {
			sql = prop.getProperty("selectBestListViews");
			
		}else {
			sql = prop.getProperty("selectBestListLikes");
		}
		
		try {		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageInfo.startBoard());
			pstmt.setInt(2, pageInfo.endBoard());
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Board board = new Board();
				board.setRowNum(rset.getInt("RNUM"));
				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardWriter(rset.getString("MEMBER_ID"));
				board.setViews(rset.getInt("VIEWS"));
				board.setLikes(rset.getInt("LIKES"));
				board.setCreatedDateStr(rset.getString("BEST_MONTH"));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int deleteBest(Connection conn, ArrayList<Board> list) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("deleteBest");
		
		try {		
			pstmt = conn.prepareStatement(sql);
			for (Board b : list) {
				pstmt.setInt(1, Integer.parseInt(b.getCreatedDateStr()));
				pstmt.setInt(2, b.getBoardNo());
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Attachment> selectAttachmentList(Connection conn, String bt, int bno) {
		// TODO Auto-generated method stub
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectAttachmentList");
		
		try {		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bt);
			pstmt.setInt(2, bno);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Attachment at = new Attachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setRefCno(rset.getInt("REF_CNO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				list.add(at);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Recipe> selectRecipeList(Connection conn, String bt, int bno) {
		// TODO Auto-generated method stub
		ArrayList<Recipe> list = new ArrayList<Recipe>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectRecipeList");
		
		try {		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bt);
			pstmt.setInt(2, bno);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Recipe r = new Recipe();
				r.setOrderNo(rset.getInt("ORDER_NO"));
				r.setRecipeContent(rset.getString("RECIPE_CONTENT"));
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<RecipeIngrd> selectRecipeIngrdList(Connection conn, String bt, int bno) {
		// TODO Auto-generated method stub
		ArrayList<RecipeIngrd> list = new ArrayList<RecipeIngrd>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectRecipeIngrdList");
		
		try {		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bt);
			pstmt.setInt(2, bno);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				RecipeIngrd ri = new RecipeIngrd();
				ri.setDose(rset.getString("DOSE"));
				ri.setIngrdCode(rset.getString("INGRD_NAME"));
				ri.setDoseCode(rset.getString("DOSE_NAME"));
				list.add(ri);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int countBestSearch(Connection conn, String search) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sql = prop.getProperty("countBestSearch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectBestSearch(Connection conn, PageInfo pageInfo, String search, String categoryCode) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "";
		if (categoryCode.equals("VIEWS")) {
			sql = prop.getProperty("selectBestSearchViews");
			
		}else {
			sql = prop.getProperty("selectBestSearchLikes");
		}
		
		try {		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, pageInfo.startBoard());
			pstmt.setInt(3, pageInfo.endBoard());
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Board board = new Board();
				board.setRowNum(rset.getInt("RNUM"));
				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardWriter(rset.getString("MEMBER_ID"));
				board.setViews(rset.getInt("VIEWS"));
				board.setLikes(rset.getInt("LIKES"));
				board.setCreatedDateStr(rset.getString("BEST_MONTH"));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}





	public int insertRecipeBoard(Connection conn, Board b) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertRecipeBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getBoardWriter());
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setDate(4, b.getCreatedDate());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertRecipe(Connection conn, ArrayList<Recipe> rList) {

		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertRecipe");
		
		try {
			for(Recipe re: rList) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, re.getOrderNo());
				pstmt.setString(2, re.getRecipeContent());
				
				result *= pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertAttachment(Connection conn, Attachment at) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, at.getRefCno());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertRecipeAttachment(Connection conn, ArrayList<Attachment> atList) {
		
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertRecipeAttachment");
		
		try {
			for(Attachment at: atList) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, at.getRefCno());
				pstmt.setString(2, at.getOriginName());
				pstmt.setString(3, at.getChangeName());
				
				result *= pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public int insertIngrd(Connection conn, ArrayList<RecipeIngrd> riList) {
		
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertIngrd");
		
		try {
			for(RecipeIngrd ri: riList) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, ri.getIngrdCode());
				pstmt.setString(2, ri.getDose());
				pstmt.setString(3, ri.getDoseCode());
				
				result *= pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

}
