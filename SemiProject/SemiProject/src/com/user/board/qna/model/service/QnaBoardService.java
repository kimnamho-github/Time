package com.user.board.qna.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.common.JDBCTemplate;
import com.common.model.vo.PageInfo;
import com.user.board.open.model.vo.Comments;
import com.user.board.qna.model.dao.QnaBoardDao;
import com.user.board.recipe.model.vo.Board;

public class QnaBoardService {

	//현재 게시글의 총 개수를 반환하는 메서드
	public int selectListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new QnaBoardDao().selectListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
	
	//Q&A게시글 조회수 증가 메서드
	public Board IncreaseQnaViews(int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new QnaBoardDao().IncreaseQnaViews(conn, bno);
		
		Board b = null;
		
		if(count > 0) {
			//UPDATE 구문이기 때문에 트랜젝션 처리를 해주고
			//사용자가 클릭하여 조회수가 증가한 게시글의 내용을 가져오기 위해
			//다시 DAO로 보내준다
			b = new QnaBoardDao().selectQnaBoard(conn, bno);
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return b;
		
	}
	
	//Q&A게시판 글 작성
	public int insertQnaBoard(String memberNo, String title, String content) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new QnaBoardDao().insertQnaBoard(conn, memberNo, title, content);
		
		//INSERT 구문 트랜잭션처리
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	//Q&A 게시글 수정 게시판에 기존 데이터 가져오기
	public Board updateQnaForm(int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Board b = new QnaBoardDao().updateQnaForm(conn, bno);
		
		//SELECT구문 트랜잭션처리 X
		JDBCTemplate.close(conn);
		
		return b;
	}
	
	//Q&A게시판 게시글 수정내용 업데이트 메서드
	public int updateQnaBoard(int bno, String title, String content) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new QnaBoardDao().updateQnaBoard(conn, bno, title, content);
		
		//UPDATE 구문이므로 트랜젝션 처리
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	//Q&A게시판 글 삭제 메서드
	public int deleteQna(int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new QnaBoardDao().deleteQna(conn, bno);
		
		//UPDATE 트랜잭션 처리
		if(result != 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	//Q&A게시판 댓글 등록 메서드
	public int insertQnaReply(Comments cm) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new QnaBoardDao().insertQnaReply(conn, cm);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	//Q&A게시판 댓글 내용 가져오기
	public ArrayList<Comments> selectReplyList(int bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Comments> list = new QnaBoardDao().selectReplyList(conn, bno);
		
		//SELECT문이라 트랜잭션처리 X
		JDBCTemplate.close(conn);
		
		return list;
	}

	//현재 Q&A 게시판 게시글의 총 개수를 반환
	public int selectQnaListCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new QnaBoardDao().selectQnaListCount(conn);
		
		//SELECT문 트랜잭션 처리X
		JDBCTemplate.close(conn);
		
		return count;
	}

	//현재 사용자가 요청한 Q&A페이지에 대해 보여질 게시글 리스트 조회하기
	public ArrayList<Board> selectQnaBoardList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Board> list = new QnaBoardDao().selectQnaBoardList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	//Q&A게시판 댓글 삭제 메서드
	public int deleteQnaReply(int bno, int rno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new QnaBoardDao().deleteQnaReply(conn, bno, rno);
		
		//UPDATE구문 트랜잭션X
		JDBCTemplate.close(conn);
		
		return result;
	}
	//Q&A게시판 댓글 수정
	public int updateQnaReply(int bno, int rno, String reContent) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new QnaBoardDao().updateQnaReply(conn, bno, rno, reContent);
		
		if(result!=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

}
