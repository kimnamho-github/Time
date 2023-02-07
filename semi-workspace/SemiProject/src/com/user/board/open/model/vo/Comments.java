package com.user.board.open.model.vo;

import java.sql.Date;

public class Comments {
	
//	COMMENTS_NO	NUMBER
//	BOARD_NO	NUMBER
//	BOARD_CODE	VARCHAR2(2 BYTE)
//	CREATED_DATE	DATE
//	STATUS	VARCHAR2(1 BYTE)
//	COMMENTS_CONTENT	VARCHAR2(1000 BYTE)
//	COMMENTS_WRITER	NUMBER >string으로 받음
	
	private int commentsNo;
	private int boardNo;
	private String boardCode;
	private Date createdDate;
	private String status;
	private String commentsContent;
	private String commentsWriter;
	
	
	
	public Comments() {
		super();
	}
	
		public Comments(int commentsNo, Date createdDate, String commentsContent, String commentsWriter) {
		super();
		this.commentsNo = commentsNo;
		this.createdDate = createdDate;
		this.commentsContent = commentsContent;
		this.commentsWriter = commentsWriter;
	}

		public Comments(int commentsNo, String boardCode, Date createdDate, String commentsContent, String commentsWriter) {
			super();
			this.commentsNo = commentsNo;
			this.boardCode = boardCode;
			this.createdDate = createdDate;
			this.commentsContent = commentsContent; 
			this.commentsWriter = commentsWriter;
		}

	public Comments(int commentsNo, int boardNo, String boardCode, Date createdDate, String status,
			String commentsContent, String commentsWriter) {
		super();
		this.commentsNo = commentsNo;
		this.boardNo = boardNo;
		this.boardCode = boardCode;
		this.createdDate = createdDate;
		this.status = status;
		this.commentsContent = commentsContent;
		this.commentsWriter = commentsWriter;
	}
	
	public Comments(int boardNo, String commentsContent, String commentsWriter) {
		super();
		this.boardNo = boardNo;
		this.commentsContent = commentsContent;
		this.commentsWriter = commentsWriter;
	}
	

	public int getCommentsNo() {
		return commentsNo;
	}

	public void setCommentsNo(int commentsNo) {
		this.commentsNo = commentsNo;
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

	public String getCommentsContent() {
		return commentsContent;
	}

	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}

	public String getCommentsWriter() {
		return commentsWriter;
	}

	public void setCommentsWriter(String commentsWriter) {
		this.commentsWriter = commentsWriter;
	}

	@Override
	public String toString() {
		return "Comments [commentsNo=" + commentsNo + ", boardNo=" + boardNo + ", boardCode=" + boardCode
				+ ", createdDate=" + createdDate + ", status=" + status + ", commentsContent=" + commentsContent
				+ ", commentsWriter=" + commentsWriter + "]";
	}

	
	
}
