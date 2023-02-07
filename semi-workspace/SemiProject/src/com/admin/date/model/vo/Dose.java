package com.admin.date.model.vo;

public class Dose {
	private String doseCode;//	Dose_CODE	VARCHAR2(10 BYTE)	정량단위 코드
	private String doseName;//	INGRD_NAME	VARCHAR2(300 BYTE)	정량단위 명칭
	@Override
	public String toString() {
		return "Dose [doseCode=" + doseCode + ", doseName=" + doseName + "]";
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
	public Dose(String doseCode, String doseName) {
		super();
		this.doseCode = doseCode;
		this.doseName = doseName;
	}
	public Dose() {
		super();
	}
	
	
}
