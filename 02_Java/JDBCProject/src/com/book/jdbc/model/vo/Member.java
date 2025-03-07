package com.book.jdbc.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String gender;
	private String address;
	private String phone;
	private Date enrollDate;
	
	public Member() {
		super();
	}

	public Member(int memberNo, String memberId, String memberPwd, String memberName, String gender, String address,
			String phone, Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.enrollDate = enrollDate;
	}
	
	

	public Member(String memberId, String memberPwd, String memberName, String gender, String address, String phone) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", gender=" + gender + ", address=" + address + ", phone=" + phone + 
				 ", enrollDate=" + enrollDate + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(memberNo, memberId, memberPwd, memberName, gender, address, phone, enrollDate);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member mem = (Member)obj;
			if(this.memberId.equals(mem.getMemberId())) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
