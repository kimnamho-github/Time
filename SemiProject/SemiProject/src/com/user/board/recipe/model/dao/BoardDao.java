package com.user.board.recipe.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.common.JDBCTemplate;
import com.common.model.vo.Attachment;
import com.common.model.vo.PageInfo;
import com.user.board.recipe.model.vo.Board;
import com.user.board.recipe.model.vo.DoseUnit;
import com.user.board.recipe.model.vo.Ingrd;
import com.user.board.recipe.model.vo.Recipe;
import com.user.board.recipe.model.vo.RecipeIngrd;

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
		String sql = prop.getProperty("selectList");
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("BOARD_NO"),
									rset.getString("MEMBER_NAME"),
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

	public ArrayList<Board> searchRecipeList(Connection conn, PageInfo pi, String searchText) {
		
		ArrayList<Board> list= new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("searchRecipeList");
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + searchText + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("BOARD_NO"),
									rset.getString("MEMBER_NAME"),
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

	public ArrayList<Ingrd> selectIngrdList(Connection conn) {
		ArrayList<Ingrd> ingrdList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectIngrdList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ingrdList.add(new Ingrd(rset.getString("INGRD_CODE"),
									  rset.getString("INGRD_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return ingrdList;
	}

	public ArrayList<DoseUnit> selectDoseUnitList(Connection conn) {
		ArrayList<DoseUnit> doseUnitList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectDoseUnitList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				doseUnitList.add(new DoseUnit(rset.getString("DOSE_CODE"),
									  rset.getString("DOSE_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return doseUnitList;
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

	public ArrayList<Attachment> selectAttachmentList(Connection conn, String bt, int bno) {
		
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
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Recipe> selectRecipeList(Connection conn, String bt, int bno) {
		
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
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<RecipeIngrd> selectRecipeIngrdList(Connection conn, String bt, int bno) {
		
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
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public Board selectBoard(Connection conn, String bt, int bno) {
		
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
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return b;
	}

	public int increaseCount(Connection conn, int bno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//이달의 베스트 레시피 불러오기 (1위부터 3위까지 좋아요가 많고 현재 기준 년월에 등록된 게시글만)
		public ArrayList<Board> bestMonthList(Connection conn) {
			
			ResultSet rset = null;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("bestList");
			
			ArrayList<Board> list = new ArrayList<>();
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					list.add(new Board(rset.getInt("BOARD_NO")
									  ,rset.getString("MEMBER_NAME")
									  ,rset.getString("BOARD_TITLE")
									  ,rset.getInt("VIEWS")
									  ,rset.getInt("LIKES")
									  ,rset.getDate("CREATED_DATE")
									  ,rset.getString("TITLEIMG")));
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
	
	
	
	
}
