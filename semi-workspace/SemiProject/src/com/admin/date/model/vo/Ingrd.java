package com.admin.date.model.vo;

public class Ingrd {

	private String ingrdCode;//	INGRD_CODE	VARCHAR2(10 BYTE)	재료 코드
	private String ingrdName;//	INGRD_NAME	VARCHAR2(300 BYTE)	재료 명칭
	@Override
	public String toString() {
		return "Ingrd [ingrdCode=" + ingrdCode + ", ingrdName=" + ingrdName + "]";
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
	public Ingrd(String ingrdCode, String ingrdName) {
		super();
		this.ingrdCode = ingrdCode;
		this.ingrdName = ingrdName;
	}
	public Ingrd() {
		super();
	}
	
}
