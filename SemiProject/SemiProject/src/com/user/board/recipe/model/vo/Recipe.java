package com.user.board.recipe.model.vo;

public class Recipe {

	private int orderNo; // 조리 내용 번호
	private int boardNo; // 게시글 번호
	private String boardCode; // 게시판 유형 코드
	private String recipeContent; // 조리 내용
	
	public Recipe() {
		super();
	}

	public Recipe(int orderNo, int boardNo, String boardCode, String recipeContent) {
		super();
		this.orderNo = orderNo;
		this.boardNo = boardNo;
		this.boardCode = boardCode;
		this.recipeContent = recipeContent;
	}

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

	@Override
	public String toString() {
		return "Recipe [orderNo=" + orderNo + ", boardNo=" + boardNo + ", boardCode=" + boardCode + ", recipeContent="
				+ recipeContent + "]";
	}
	
}
