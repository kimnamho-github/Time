package com.admin.board.model.vo;

public class BoardType {
	private String boardCode;//	BOARD_CODE	VARCHAR2(2 BYTE)	게시판 유형 코드
	private String boardName;//	BOARD_NAME	VARCHAR2(10 BYTE)	게시판 유형 명칭
	private String boardKorName;//	BOARD_KOR_NAME	VARCHAR2(100 BYTE)	
	/*생성자*/
	public BoardType() {
		super();
	}
	/*toString*/
	@Override
	public String toString() {
		return "BoardType [boardCode=" + boardCode + ", boardName=" + boardName + ", boardKorName=" + boardKorName
				+ "]";
	}
	/*get&set*/
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
}
