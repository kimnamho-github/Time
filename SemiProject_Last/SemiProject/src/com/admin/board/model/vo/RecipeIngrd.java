package com.admin.board.model.vo;

public class RecipeIngrd {
	private String ingrdCode;//	INGRD_CODE	VARCHAR2(10 BYTE)	재료 코드
	private int boardNo;//	BOARD_NO	NUMBER	게시글번호
	private String boardCode;//	BOARD_CODE	VARCHAR2(10 BYTE)	게시판 유형 코드
	private String dose;//	DOSE	VARCHAR2(30 BYTE)	정량
	private String doseCode;//	DOSE_CODE	VARCHAR2(10 BYTE)	정량 단위 코드
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
	public RecipeIngrd(String ingrdCode, int boardNo, String boardCode, String dose, String doseCode) {
		super();
		this.ingrdCode = ingrdCode;
		this.boardNo = boardNo;
		this.boardCode = boardCode;
		this.dose = dose;
		this.doseCode = doseCode;
	}
	public RecipeIngrd() {
		super();
	}
	
	
}
