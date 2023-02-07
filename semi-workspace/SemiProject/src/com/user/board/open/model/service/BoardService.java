package com.user.board.open.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.common.JDBCTemplate;
import com.common.model.vo.PageInfo;
import com.user.board.open.model.dao.BoardDao;
import com.user.board.open.model.vo.Board;
import com.user.board.open.model.vo.Comments;

public class BoardService {

	public int selectOpenListCount() {
		
		Connection conn = JDBCTemplate.getConnection();

		int count = new BoardDao().selectOpenListCount(conn);
		
		JDBCTemplate.close(conn);
		
		
		return count; 
	}
	

	public ArrayList<Board> selectOpenList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Board> list = new BoardDao().selectOpenList(conn,pi);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}

	


	public int insertOpenBoard(String memberNo, String boardTitle, String boardContent) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().insertOpenBoard(conn,memberNo,boardTitle,boardContent);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn); 
		
		return result; 
	}

	
	
	public int increaseOpenBoardCount(int openboardNo) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().increaseOpenBoardCount(conn,openboardNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result; 
		
		
	}
	
	
	//게시글 하나만 가져오는 메소드
	public Board selectOpenBoard(int openboardNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Board b = new BoardDao().selectOpenBoard(conn,openboardNo);
		
		JDBCTemplate.close(conn);
		
		return b; 
	}


	//게시글 수정 메소드
	public int updateOpenBoard(Board b) {
		
		Connection conn= JDBCTemplate.getConnection();
		
		int result = new BoardDao().updateOpenBoard(conn,b);
		
		if(result>0) { 
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
			
		} 
		JDBCTemplate.close(conn);
		
		
		return result;
	}


	public int deleteOpenBoard(int boardNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().deleteOpenBoard(conn, boardNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
			JDBCTemplate.close(conn);
		
		
			return result;
	}


	public int insertComments(Comments c) {

		Connection conn= JDBCTemplate.getConnection();
		
		int result = new BoardDao().insertComments(conn,c);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
			JDBCTemplate.close(conn);
		
		
			return result;
	}

	//댓글리스트 조회 메소드
	public ArrayList<Comments> selectCommentsList(int ono) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Comments> list = new BoardDao().selectCommentsList(conn, ono);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//댓글 삭제 메소드
	public int deleteComments(int ono, int rno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().deleteComments(conn, ono, rno);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return result;
	}



	//댓글 수정 메소드
	public int updateComments(int ono, int rno, String rc) {

		Connection conn= JDBCTemplate.getConnection();
		
		int result = new BoardDao().updateComments(conn,ono,rno,rc);
		
		
		if(result>0) { 
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
			
		} 
		JDBCTemplate.close(conn);
		
		
		return result;
	}


	public ArrayList<Board> selectMainList() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Board> list = new BoardDao().selectMainList(conn);
		
		return list; 
	}


	





	






	
	
	
	
	
	
	
	
	
	

}

