package com.admin.member.model.vo;

import java.sql.Date;

public class AdminMember {
	private int memberNo;//	MEMBER_NO	NUMBER	회원 번호
	private String memberId;//	MEMBER_ID	VARCHAR2(30 BYTE)	회원 아이디
	private String memberPwd;//	MEMBER_PWD	VARCHAR2(30 BYTE)	회원 비밀번호
	private String memberName;//	MEMBER_NAME	VARCHAR2(60 BYTE)	회원 이름
	private String phone;//	PHONE	VARCHAR2(60 BYTE)	회원 전화번호
	private String email;//	EMAIL	VARCHAR2(300 BYTE)	회원 이메일
	private String address;//	ADDRESS	VARCHAR2(600 BYTE)	회원 주소
	private String gradeCode;//	GRADE_CODE	VARCHAR2(2 BYTE)	회원등급코드
	private String status;//	STATUS	VARCHAR2(1 BYTE)	상태값(Y/N)
	private Date subscriptionDate;//	SUBSCRIPTION_DATE	DATE	가입일자
	private Date modifiedDate;//	MODIFIED_DATE	DATE	수정일자
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", gradeCode="
				+ gradeCode + ", status=" + status + ", subscriptionDate=" + subscriptionDate + ", modifiedDate="
				+ modifiedDate + "]";
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public AdminMember(int memberNo, String memberId, String memberPwd, String memberName, String phone, String email,
			String address, String gradeCode, String status, Date subscriptionDate, Date modifiedDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.gradeCode = gradeCode;
		this.status = status;
		this.subscriptionDate = subscriptionDate;
		this.modifiedDate = modifiedDate;
	}
	public AdminMember() {
		super();
	}
	
	
}
