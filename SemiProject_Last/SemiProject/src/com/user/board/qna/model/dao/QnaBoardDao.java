package com.user.board.qna.model.dao;

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
import com.user.board.open.model.vo.Comments;
import com.user.board.recipe.model.vo.Board;

public class QnaBoardDao {

	private Properties prop = new Properties();
	
	public QnaBoardDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(QnaBoardDao.class.getResource("/db/sql/user/qna-board-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//현재 게시글의 총 개수를 반환하는
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
	
	//Q&A게시판 조회수 증가
	public int IncreaseQnaViews(Connection conn, int bno) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("IncreaseQnaViews");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			count = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return count;
	}
	
	//현재 사용자가 요청한 Q&A페이지에 대해 보여질 게시글 리스트 조회하기
	public ArrayList<Board> selectQnaBoardList(Connection conn, PageInfo pi) {
			
		ResultSet rset = null;
		//주의) ArrayList<Board> list = null; 로 초기화 하는 경우
		//객체를 담을 공간을 new 연산자를 통해 만들어 놓지 않았기 때문에 null예외가 발생한다
		//선언을 통해 list에 담을 공간을 만들어주자.
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectQnaBoardList");
		
		/*
		 * boardLimit이 10이라고 가정하면
		 * currentPage = 1 -> 시작값:1 끝값:10
		 * currentPage = 2 -> 시작값:11 끝값:20
		 * currentPage = 3 -> 시작값:21 끝값:30
		 * 
		 * 시작값 = (currentPage - 1) * boardLimit + 1 / ex)(1-1)*11 = 0 / (2-1)*11 = 11 0,11,22,...
		 * 끝값 = currentPage * boardLimit				/ ex) 1 * 10 = 10 / 2 * 10 = 20 = 20 10,20,30...
		 * 
		 * */
		
		int startRow = pi.startBoard();
		int endRow = pi.endBoard();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			//while문의 경우 객체를 계속 생성하기 때문에 ArrayList<Board>를 선언해 주어야 한다.
			while(rset.next()) {
				
				list.add(new Board(rset.getInt("BOARD_NO") // boardNo
								  ,rset.getString("MEMBER_NAME")
								  ,rset.getString("BOARD_TITLE")
								  ,rset.getString("BOARD_CONTENT")
								  ,rset.getInt("VIEWS")
								  ,rset.getInt("LIKES")
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
	
	//Q&A 게시글 상세조회
	public Board selectQnaBoard(Connection conn, int bno) {
		
		Board b = new Board();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectQnaBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContent(rset.getString("BOARD_CONTENT"));
				b.setBoardWriter(rset.getString("MEMBER_ID"));
				b.setCreatedDate(rset.getDate("CREATED_DATE"));
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
	
	//Q&A게시판 글 작성
	public int insertQnaBoard(Connection conn, String memberNo, String title, String content) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertQnaBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberNo);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	//Q&A 게시글 수정 게시판에 기존 데이터 가져오기
	public Board updateQnaForm(Connection conn, int bno) {
		
		Board b = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateQnaForm");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("BOARD_NO")
							 ,rset.getString("BOARD_CODE")
							 ,rset.getString("BOARD_WRITER")
							 ,rset.getString("BOARD_TITLE")
							 ,rset.getString("BOARD_CONTENT")
							 ,rset.getInt("VIEWS")
							 ,rset.getInt("LIKES")
							 ,rset.getDate("CREATED_DATE")
							 ,rset.getString("STATUS"));	
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
	
	//Q&A게시판 게시글 수정내용 업데이트
	public int updateQnaBoard(Connection conn, int bno, String title, String content) {
		
		//UPDATE 구문이므로 처리된 행의 수를 반환
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateQnaBoard");
		
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setInt(3, bno);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}	
			return result;
	}

	//Q&A게시판 댓글 등록
	public int insertQnaReply(Connection conn, Comments cm) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertQnaReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cm.getBoardNo());
			pstmt.setString(2, cm.getCommentsContent());
			pstmt.setString(3, cm.getCommentsWriter());
				
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//Q&A게시판 게시글 작성 댓글 내용 가져오기
	public ArrayList<Comments> selectReplyList(Connection conn, int bno) {
		
		ResultSet rset = null;
		ArrayList<Comments> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Comments(rset.getInt("COMMENTS_NO")
										,rset.getDate("CREATED_DATE")
										,rset.getString("COMMENTS_CONTENT")
										,rset.getString("MEMBER_NAME")
									 ));
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

	//Q&A게시판 글 삭제
	public int deleteQna(Connection conn, int bno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteQna");
		
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

	//현재 Q&A 게시판 게시글의 총 개수를 반환
	public int selectQnaListCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQnaListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
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

	//Q&A게시판 댓글 삭제
	public int deleteQnaReply(Connection conn, int bno, int rno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteQnaReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rno);
			pstmt.setInt(2, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	//Q&A게시판 댓글 수정
	public int updateQnaReply(Connection conn, int bno, int rno, String reContent) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateQnaReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reContent);
			pstmt.setInt(2, bno);
			pstmt.setInt(3, rno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
