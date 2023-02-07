package com.user.board.model.vo;

public class BestMonth {

	private int bestMonth; // 베스트(월)
	private int boardNo; // 게시글 번호
	private String boardCode; // 게시판 유형 코드
	private int monthView; // 한달간 조회수
	private int monthLike; // 한달간 좋아요수
	
	public BestMonth() {
		super();
	}

	public BestMonth(int bestMonth, int boardNo, String boardCode, int monthView, int monthLike) {
		super();
		this.bestMonth = bestMonth;
		this.boardNo = boardNo;
		this.boardCode = boardCode;
		this.monthView = monthView;
		this.monthLike = monthLike;
	}

	public int getBestMonth() {
		return bestMonth;
	}

	public void setBestMonth(int bestMonth) {
		this.bestMonth = bestMonth;
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

	public int getMonthView() {
		return monthView;
	}

	public void setMonthView(int monthView) {
		this.monthView = monthView;
	}

	public int getMonthLike() {
		return monthLike;
	}

	public void setMonthLike(int monthLike) {
		this.monthLike = monthLike;
	}

	@Override
	public String toString() {
		return "BestMonth [bestMonth=" + bestMonth + ", boardNo=" + boardNo + ", boardCode=" + boardCode
				+ ", monthView=" + monthView + ", monthLike=" + monthLike + "]";
	}
	
}
