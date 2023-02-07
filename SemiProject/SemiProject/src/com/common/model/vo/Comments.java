package com.common.model.vo;

import java.sql.Date;

public class Comments {
	
	private int commentNo; // 게시판댓글번호
	private int boardNo; // 게시글번호
	private String boardCode; // 게시판등급
	private Date createDate; // 작성일자
	private String status; // 상태값(Y/N)
	private String commentContent; // 작성내용
	private int commentWriter; // 작성자번호
	
	public Comments() {
		super();
	}

	public Comments(int commentNo, int boardNo, String boardCode, Date createDate, String status, String commentContent,
			int commentWriter) {
		super();
		this.commentNo = commentNo;
		this.boardNo = boardNo;
		this.boardCode = boardCode;
		this.createDate = createDate;
		this.status = status;
		this.commentContent = commentContent;
		this.commentWriter = commentWriter;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(int commentWriter) {
		this.commentWriter = commentWriter;
	}

	@Override
	public String toString() {
		return "Comments [commentNo=" + commentNo + ", boardNo=" + boardNo + ", boardCode=" + boardCode
				+ ", createDate=" + createDate + ", status=" + status + ", commentContent=" + commentContent
				+ ", commentWriter=" + commentWriter + "]";
	}

	
	
}
