package com.user.board.notice.model.vo;

import java.sql.Date;

public class NReply {
	private	int comments_no;	//COMMENTS_NO
	private	int	board_no; //BOARD_NO
	private	String board_code;	//BOARD_CODE
	private	Date created_date;	//CREATED_DATE
	private	String status;//STATUS
	private	String comments_content;	//COMMENTS_CONTENT
	private	String	comments_writer;//COMMENTS_WRITER
	
	public NReply() {
		super();
	}
	public NReply(int comments_no, int board_no, String board_code, Date created_date, String status,
			String comments_content, String comments_writer) {
		super();
		this.comments_no = comments_no;
		this.board_no = board_no;
		this.board_code = board_code;
		this.created_date = created_date;
		this.status = status;
		this.comments_content = comments_content;
		this.comments_writer = comments_writer;
	}
	
	public NReply(int comments_no, Date created_date, String comments_content, String comments_writer) {
		super();
		this.comments_no = comments_no;
		this.created_date = created_date;
		this.comments_content = comments_content;
		this.comments_writer = comments_writer;
	}
	
	public NReply(int comments_no, int board_no, String board_code, String comments_content, String comments_writer) {
		super();
		this.comments_no = comments_no;
		this.board_no = board_no;
		this.board_code = board_code;
		this.comments_content = comments_content;
		this.comments_writer = comments_writer;
	}
	public int getComments_no() {
		return comments_no;
	}
	public void setComments_no(int comments_no) {
		this.comments_no = comments_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
		this.board_code = board_code;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments_content() {
		return comments_content;
	}
	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}
	public String getComments_writer() {
		return comments_writer;
	}
	public void setComments_writer(String comments_writer) {
		this.comments_writer = comments_writer;
	}
	@Override
	public String toString() {
		return "NReply [comments_no=" + comments_no + ", board_no=" + board_no + ", board_code=" + board_code
				+ ", created_date=" + created_date + ", status=" + status + ", comments_content=" + comments_content
				+ ", comments_writer=" + comments_writer + "]";
	}
	public void setReplayContent(String content) {
		// TODO Auto-generated method stub
		
	}

	
	

	

}
