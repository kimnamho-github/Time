package com.user.board.model.vo;

public class DoseUnit {

	private String doseCode; // 정량 단위 코드
	private String doseName; // 정량 단위 명칭
	
	public DoseUnit() {
		super();
	}

	public DoseUnit(String doseCode, String doseName) {
		super();
		this.doseCode = doseCode;
		this.doseName = doseName;
	}

	public String getDoseCode() {
		return doseCode;
	}

	public void setDoseCode(String doseCode) {
		this.doseCode = doseCode;
	}

	public String getDoseName() {
		return doseName;
	}

	public void setDoseName(String doseName) {
		this.doseName = doseName;
	}

	@Override
	public String toString() {
		return "DoseUnit [doseCode=" + doseCode + ", doseName=" + doseName + "]";
	}

}
