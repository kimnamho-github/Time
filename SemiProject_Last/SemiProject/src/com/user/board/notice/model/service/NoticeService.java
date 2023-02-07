package com.user.board.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.common.JDBCTemplate;
import com.common.model.vo.PageInfo;
import com.user.board.notice.model.dao.NoticeDao;
import com.user.board.notice.model.vo.NReply;
import com.user.board.notice.model.vo.Notice;

public class NoticeService {
	
	//공지사항 리스트 조회
	public ArrayList<Notice> selectNoticeList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	//공지사항 작성 메소드
	public int insertNotice(String MemberNo, String title, String content) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().insertNotice(conn,MemberNo,title,content);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	//조회수 증가용 메소드
	public Notice increaseCount(int NoticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().increaseCount(conn,NoticeNo);
		Notice n = null;
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			
			n = new NoticeDao().selectNotice(conn,NoticeNo);
		}else {
			JDBCTemplate.rollback(conn);
			
		}
		JDBCTemplate.rollback(conn);
		return n;
	}
	//공지사항 상세 조회 메소드
	public Notice selectNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		Notice n = new NoticeDao().selectNotice(conn, noticeNo);
		
		JDBCTemplate.close(conn);
		
		return n;
	}
	//공지글 수정 메소드
	public int updateNotice(int nno, String title, String content) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().updateNotice(conn,nno,title,content);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	//공지사항 삭제 메소드
	public int deleteNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().deleteNotice(conn,noticeNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return result;
	}
	//게시글 총 개수 반환 메소드
	public int selectListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new NoticeDao().selectListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
	
	public ArrayList<Notice> selectList(PageInfo pageInfo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Notice> nlist = new NoticeDao().selectList(conn,pageInfo);
		
		JDBCTemplate.close(conn);
		
		return nlist;
		
		
		
	}
	//사용자 요청 페이지 목록 메소드
	public int insertReply(NReply r) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().insertNotice(conn,r);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public ArrayList<NReply> selectReplyList(int nno) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<NReply> rlist = new NoticeDao().selectReplyList(conn,nno);
		
		JDBCTemplate.close(conn);
		
		return rlist;
	}
}




