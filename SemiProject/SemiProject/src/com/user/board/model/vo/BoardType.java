package com.user.board.model.vo;

public class BoardType {

	private String boardCode; // 게시판 유형 코드
	private String boardName; // 게시판 유형 명칭
	private String boardKorName; // 게시판 유형 명칭
	
	public BoardType() {
		super();
	}

	public BoardType(String boardCode, String boardName, String boardKorName) {
		super();
		this.boardCode = boardCode;
		this.boardName = boardName;
		this.boardKorName = boardKorName;
	}

	public String getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardKorName() {
		return boardKorName;
	}

	public void setBoardKorName(String boardKorName) {
		this.boardKorName = boardKorName;
	}

	@Override
	public String toString() {
		return "BoardType [boardCode=" + boardCode + ", boardName=" + boardName + ", boardKorName=" + boardKorName
				+ "]";
	}
	
	
}
