package com.admin.member.model.vo;

public class MemberGrade {
	private String gradeCode;//	GRADE_CODE	VARCHAR2(2 BYTE)	회원 등급 코드
	private String gradeName;//	GRADE_NAME	VARCHAR2(10 BYTE)	회원 등급 명칭
	@Override
	public String toString() {
		return "MemberGrade [gradeCode=" + gradeCode + ", gradeName=" + gradeName + "]";
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public MemberGrade(String gradeCode, String gradeName) {
		super();
		this.gradeCode = gradeCode;
		this.gradeName = gradeName;
	}
	public MemberGrade() {
		super();
	}
	
}
