package com.user.board.model.vo;

public class RecipeIngrd {

	private String ingrdCode; // 재료 코드
	private int boardNo; // 게시글번호
	private String boardCode; // 게시판 유형 코드
	private String dose; // 정량
	private String doseCode; // 정량 단위 코드
	
	public RecipeIngrd() {
		super();
	}

	public RecipeIngrd(String ingrdCode, int boardNo, String boardCode, String dose, String doseCode) {
		super();
		this.ingrdCode = ingrdCode;
		this.boardNo = boardNo;
		this.boardCode = boardCode;
		this.dose = dose;
		this.doseCode = doseCode;
	}

	public String getIngrdCode() {
		return ingrdCode;
	}

	public void setIngrdCode(String ingrdCode) {
		this.ingrdCode = ingrdCode;
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

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getDoseCode() {
		return doseCode;
	}

	public void setDoseCode(String doseCode) {
		this.doseCode = doseCode;
	}

	@Override
	public String toString() {
		return "RecipeIngrd [ingrdCode=" + ingrdCode + ", boardNo=" + boardNo + ", boardCode=" + boardCode + ", dose="
				+ dose + ", doseCode=" + doseCode + "]";
	}

}
