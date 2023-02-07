package com.user.board.model.vo;

public class Ingrd {

	private String ingrdCode; // 재료 코드
	private String ingrdName; // 재료 명칭
	
	public Ingrd() {
		super();
	}

	public Ingrd(String ingrdCode, String ingrdName) {
		super();
		this.ingrdCode = ingrdCode;
		this.ingrdName = ingrdName;
	}

	public String getIngrdCode() {
		return ingrdCode;
	}

	public void setIngrdCode(String ingrdCode) {
		this.ingrdCode = ingrdCode;
	}

	public String getIngrdName() {
		return ingrdName;
	}

	public void setIngrdName(String ingrdName) {
		this.ingrdName = ingrdName;
	}

	@Override
	public String toString() {
		return "Ingrd [ingrdCode=" + ingrdCode + ", ingrdName=" + ingrdName + "]";
	}
	
}
