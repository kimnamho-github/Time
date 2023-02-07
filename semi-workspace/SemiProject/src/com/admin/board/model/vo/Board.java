package com.admin.board.model.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Board {
	private int rowNum;//ROWNUM
	private int boardNo;//	BOARD_NO	NUMBER	게시글 번호
	private String boardCode;//	BOARD_CODE	VARCHAR2(2 BYTE)	게시판 유형 코드
	private String boardName;//	BOARD_CODE	VARCHAR2(2 BYTE)	게시판 유형 코드
	private String boardWriter;//	BOARD_WRITER	NUMBER	작성자 번호
	private String boardTitle;//	BOARD_TITLE	VARCHAR2(1000 BYTE)	게시글 제목
	private String boardContent;//	BOARD_CONTENT	VARCHAR2(4000 BYTE)	게시글 내용
	private int Views;//	VIEWS	NUMBER	조회수
	private int Likes;//	LIKES	NUMBER	좋아요
	private Date createdDate;//	CREATED_DATE	DATE	작성일자
	private String status;//	STATUS	VARCHAR2(1 BYTE)	상태값(Y/N)
	private String createdDateStr;

	/*생성자*/
	public Board() {
		super();
	}
	
	public String getCreatedDateStr() {
		return createdDateStr;
	}

	public void setCreatedDateStr(String createdDateStr) {
		this.createdDateStr = createdDateStr;
	}

	/*toString*/
	@Override
	public String toString() {
		return "Board {rowNum:" + rowNum + ", boardNo:" + boardNo + ", boardCode:" + boardCode + ", boardName="
				+ boardName + ", boardWriter:" + boardWriter + ", boardTitle:" + boardTitle + ", boardContent:"
				+ boardContent + ", Views:" + Views + ", Likes:" + Likes + ", createdDate:" + createdDate + ", status:"
				+ status + "}";
	}
	
	/*get&set*/
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		this.createdDateStr = new SimpleDateFormat("YYYY/MM/dd").format(createdDate);

	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getViews() {
		return Views;
	}
	public void setViews(int views) {
		Views = views;
	}
	public int getLikes() {
		return Likes;
	}
	public void setLikes(int likes) {
		Likes = likes;
	}
	
	
	
}
