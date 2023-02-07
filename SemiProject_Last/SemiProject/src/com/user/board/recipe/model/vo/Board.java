package com.user.board.recipe.model.vo;

import java.sql.Date;

public class Board {
	
	private int boardNo; // 게시글 번호
	private String boardCode; // 게시판 유형 코드
	private String boardWriter; // 작성자 번호
	private String boardTitle; // 게시글 제목
	private String boardContent; // 게시글 내용
	private int views; // 조회수
	private int likes; // 좋아요수
	private Date createdDate; // 작성일자
	private String status; // 상태값(Y/N)
	private String titleImg; // 레시피게시판 썸네일에 필요한 필드변수
	
	public Board() {
		super();
	}

	public Board(int boardNo, String boardCode, String boardWriter, String boardTitle, String boardContent, int views,
			int likes, Date createdDate, String status, String titleImg) {
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
		this.titleImg = titleImg;
	}
	
	public Board(int boardNo, String boardWriter, String boardTitle, int likes, int views, String titleImg) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.likes = likes;
		this.views = views;
		this.titleImg = titleImg;
	}
	
	public Board(int boardNo, String boardWriter, String boardTitle, int views, int likes, Date createdDate,
			String titleImg) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.views = views;
		this.likes = likes;
		this.createdDate = createdDate;
		this.titleImg = titleImg;
	}

	public Board(String boardWriter, String boardTitle, int views, int likes, String titleImg) {
		super();
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.views = views;
		this.likes = likes;
		this.titleImg = titleImg;
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

	public Board(int boardNo, String boardWriter, String boardTitle, String boardContent, int views, int likes,
			Date createdDate) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.views = views;
		this.likes = likes;
		this.createdDate = createdDate;
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

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardCode=" + boardCode + ", boardWriter=" + boardWriter
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", views=" + views + ", likes="
				+ likes + ", createdDate=" + createdDate + ", status=" + status + ", titleImg=" + titleImg + "]";
	}

}
