package com.indie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminVO {
	private int adm_num;
	private String adm_id;
	private String adm_pwd;
	private String adm_email;
	private int adm_auth;
	
	public int getAdm_num() {
		return adm_num;
	}
	public void setAdm_num(int adm_num) {
		this.adm_num = adm_num;
	}
	public String getAdm_id() {
		return adm_id;
	}
	public void setAdm_id(String adm_id) {
		this.adm_id = adm_id;
	}
	public String getAdm_pwd() {
		return adm_pwd;
	}
	public void setAdm_pwd(String adm_pwd) {
		this.adm_pwd = adm_pwd;
	}
	public String getAdm_email() {
		return adm_email;
	}
	public void setAdm_email(String adm_email) {
		this.adm_email = adm_email;
	}
	public int getAdm_auth() {
		return adm_auth;
	}
	public void setAdm_auth(int adm_auth) {
		this.adm_auth = adm_auth;
	}
}
