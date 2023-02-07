package com.user.board.notice.model.vo;

import java.sql.Date;

public class Notice {		
	private int boardNo; //	BOARD_NO	NUMBER
	private String boardWriter; //	BOARD_WRITER	NUMBER
	private String boardTitle; //	BOARD_TITLE	VARCHAR2(1000 BYTE)
	private String boardContent; //	BOARD_CONTENT	VARCHAR2(4000 BYTE)
	private int views; //	VIEWS	NUMBER
	private Date createdDate;//	CREATED_DATE	DATE
	private String status; //	STATUS	VARCHAR2(1 BYTE)
//	
	public Notice() {
		super();
	}


public Notice(int boardNo, String boardWriter, String boardTitle, String boardContent, int views, Date createdDate) {
	super();
	this.boardNo = boardNo;
	this.boardWriter = boardWriter;
	this.boardTitle = boardTitle;
	this.boardContent = boardContent;
	this.views = views;
	this.createdDate = createdDate;
}

public Notice(int boardNo, String boardWriter, String boardTitle, String boardContent, int views, Date createdDate,
		String status) {
	super();
	this.boardNo = boardNo;
	this.boardWriter = boardWriter;
	this.boardTitle = boardTitle;
	this.boardContent = boardContent;
	this.views = views;
	this.createdDate = createdDate;
	this.status = status;
}

public Notice(int boardNo, String boardWriter, String boardTitle, int views, Date createdDate) {
	super();
	this.boardNo = boardNo;
	this.boardWriter = boardWriter;
	this.boardTitle = boardTitle;
	this.views = views;
	this.createdDate = createdDate;
}


public int getBoardNo() {
	return boardNo;
}
public void setBoardNo(int boardNo) {
	this.boardNo = boardNo;
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
	return "Notice [boardNo=" + boardNo + ", boardCode="  + ", boardWriter=" + boardWriter + ", boardTitle="
			+ boardTitle + ", boardContent=" + boardContent + ", views=" + views + ", createdDate=" + createdDate
			+ ", status=" + status + "]";
}
	
	
}
