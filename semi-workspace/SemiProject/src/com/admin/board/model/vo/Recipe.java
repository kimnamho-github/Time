package com.admin.board.model.vo;

public class Recipe {
	private int orderNo;//	ORDER_NO	NUMBER	조리 내용 번호
	private int boardNo;//	BOARD_NO	NUMBER	게시글 번호
	private String boardCode;//	BOARD_CODE	VARCHAR2(2 BYTE)	게시판 유형 코드
	private String recipeContent;//	RECIPE_CONTENT	VARCHAR2(2000 BYTE)	조리 내용
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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
	public String getRecipeContent() {
		return recipeContent;
	}
	public void setRecipeContent(String recipeContent) {
		this.recipeContent = recipeContent;
	}
	public Recipe(int orderNo, int boardNo, String boardCode, String recipeContent) {
		super();
		this.orderNo = orderNo;
		this.boardNo = boardNo;
		this.boardCode = boardCode;
		this.recipeContent = recipeContent;
	}
	public Recipe() {
		super();
	}
	@Override
	public String toString() {
		return "Recipe [orderNo=" + orderNo + ", boardNo=" + boardNo + ", boardCode=" + boardCode + ", recipeContent="
				+ recipeContent + "]";
	}
	
	
}
