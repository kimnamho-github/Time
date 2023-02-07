package com.user.board.notice.model.dao;

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
import com.user.board.notice.model.vo.NReply;
import com.user.board.notice.model.vo.Notice;

public class NoticeDao {

	private Properties prop = new Properties();
	
	public NoticeDao(){
		String filePath = NoticeDao.class.getResource("/db/sql/user/notice-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	//공지사항 리스트 조회
	public ArrayList<Notice> selectNoticeList(Connection conn) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("BOARD_NO")
									,rset.getString("MEMBER_ID")
									,rset.getString("BOARD_TITLE")
									,rset.getString("BOARD_CONTENT")
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
	//공지사항 작성 메소드
	public int insertNotice(Connection conn, String MemberNo, String title, String content) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Integer.parseInt(MemberNo));
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	//조회수 증가용 메소드
	public int increaseCount(Connection conn, int NoticeNo) {
	
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, NoticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}
	//공지사항 상세 조회 메소드
	public Notice selectNotice(Connection conn, int NoticeNo) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectNotice");
		Notice n = null;		
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, NoticeNo);
					
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						n = new Notice(rset.getInt("BOARD_NO")
									  ,rset.getString("MEMBER_ID")
									  ,rset.getString("BOARD_TITLE")
									  ,rset.getString("BOARD_CONTENT")
									  ,rset.getInt("VIEWS")
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
				return n;
	}
	//공지글 수정 메소드
	public int updateNotice(Connection conn, int nno, String title, String content) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, nno);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}	
		return result;
	}
	//공지사항 삭제 메소드
	public int deleteNotice(Connection conn, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	
		
	}
	//게시글 총 개수 반환 메소드
	public int selectListCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
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

	//사용자 요청 페이지 목록 메소드
	public ArrayList<Notice> selectList(Connection conn, PageInfo pageInfo) {
		ResultSet rset = null;
		ArrayList<Notice> nlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectList");
		
		int startRow = (pageInfo.getCurrentPage()-1) * pageInfo.getBoardLimit()+1;
		int endRow = pageInfo.getCurrentPage() * pageInfo.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				nlist.add(new Notice(rset.getInt("BOARD_NO")
								  ,rset.getString("MEMBER_ID")
								  ,rset.getString("BOARD_TITLE")
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

		
		return nlist;
	}
	//공지사항 작성 메소드 
	public int insertNotice(Connection conn, NReply r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReply");
System.out.println(r.getComments_content());
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getBoard_no());
			pstmt.setString(2, r.getBoard_code());
			pstmt.setString(3, ""+r.getComments_content());
			pstmt.setInt(4, Integer.parseInt(r.getComments_writer()));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public ArrayList<NReply> selectReplyList(Connection conn, int nno) {
		 
		ArrayList<NReply> rlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rlist.add(new NReply(rset.getInt("COMMENTS_NO")
									,rset.getDate("CREATED_DATE")
									,rset.getString("COMMENTS_CONTENT")
									,rset.getString("MEMBER_ID")));
							}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rlist;
	}
		
	}

