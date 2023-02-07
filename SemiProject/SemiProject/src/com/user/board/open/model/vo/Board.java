package com.user.board.open.model.vo;

import java.sql.Date;

public class Board {
	

//	BOARD_NO	NUMBER
//	BOARD_CODE	VARCHAR2(2 BYTE)
//	BOARD_WRITER	NUMBER
//	BOARD_TITLE	VARCHAR2(1000 BYTE)
//	BOARD_CONTENT	VARCHAR2(4000 BYTE)
//	VIEWS	NUMBER
//	LIKES	NUMBER
//	CREATED_DATE	DATE
//	STATUS	VARCHAR2(1 BYTE)
	
	
	private int boardNo;
	private String boardCode;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private int views;
	private int likes;
	private Date createdDate;
	private String status;
	private String titleImg; // 레시피게시판 썸네일에 필요한 필드변수
	
	
	public Board() {
		super();
	}


	public Board(int boardNo, String boardWriter, String boardTitle, int views, int likes, String titleImg) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.views = views;
		this.likes = likes;
		this.titleImg = titleImg;
	}
	
	public String getTitleImg() {
		return titleImg;
	}


	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}


	public Board(int boardNo, String boardWriter, String boardTitle, String boardContent, int likes, Date createdDate) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.likes = likes;
		this.createdDate = createdDate;
	}






	public Board(int boardNo, String boardCode, String boardWriter, String boardTitle, String boardContent, int views,
			int likes, Date createdDate) {
		super();
		this.boardNo = boardNo;
		this.boardCode = boardCode;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.views = views;
		this.likes = likes;
		this.createdDate = createdDate;
	}






	public Board(int boardNo, String boardWriter, String boardTitle, int views, Date createdDate) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.views = views;
		this.createdDate = createdDate;
	}



	public Board(int boardNo, String boardCode, String boardWriter, String boardTitle, String boardContent, int views,
			int likes, Date createdDate, String status) {
		super();
		this.boardNo = boardNo;
		this.boardCode = boardCode;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.views = views;
		this.likes = likes;
		this.createdDate = createdDate;
		this.status = status;
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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardCode=" + boardCode + ", boardWriter=" + boardWriter
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", views=" + views + ", likes="
				+ likes + ", createdDate=" + createdDate + ", status=" + status + ", titleImg=" + titleImg + "]";
	}


	
	
	
	
	
}

