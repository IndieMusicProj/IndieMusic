package com.indie.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private int mb_num;
	private String mb_id;
	private String mb_pwd;
	private String mb_name;
	private String mb_email;
	private String mb_zipNum;
	private String mb_address;
	private String mb_mobile;
	private Timestamp mb_indate;
	
	public int getMb_num() {
		return mb_num;
	}



	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
	}



	public String getMb_id() {
		return mb_id;
	}



	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}



	public String getMb_pwd() {
		return mb_pwd;
	}



	public void setMb_pwd(String mb_pwd) {
		this.mb_pwd = mb_pwd;
	}



	public String getMb_name() {
		return mb_name;
	}



	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}



	public String getMb_email() {
		return mb_email;
	}



	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}



	public String getMb_zipNum() {
		return mb_zipNum;
	}



	public void setMb_zipNum(String mb_zipNum) {
		this.mb_zipNum = mb_zipNum;
	}



	public String getMb_address() {
		return mb_address;
	}



	public void setMb_address(String mb_address) {
		this.mb_address = mb_address;
	}



	public String getMb_mobile() {
		return mb_mobile;
	}



	public void setMb_mobile(String mb_mobile) {
		this.mb_mobile = mb_mobile;
	}



	public Timestamp getMb_indate() {
		return mb_indate;
	}



	public void setMb_indate(Timestamp mb_indate) {
		this.mb_indate = mb_indate;
	}



	@Override
	public String toString() {
		return "MemberVO [mb_num=" + mb_num + ", mb_id=" + mb_id + ", mb_pwd=" + mb_pwd + ", mb_name=" + mb_name
				+ ", mb_email=" + mb_email + ", mb_zipNum=" + mb_zipNum + ", mb_address=" + mb_address + ", mb_mobile="
				+ mb_mobile + ", mb_indate=" + mb_indate + "]";
	}
}
