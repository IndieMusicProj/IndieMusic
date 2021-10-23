package com.indie.dto;

import java.sql.Timestamp;

public class PlaylistVO {

	private int pl_num; // 플레이리스트 순번
	//private String m_id; // 노래 고유 번호 String?? // MusicVO m_id에서 생성 후 사용
	private String mb_id; // 아이디 // MemberVO mb_id
	private String pl_title;// 플레이리스트 제목
	private Timestamp pl_inDate; // 플레이리스트 담은 날짜
	
	public int getPl_num() {
		return pl_num;
	}
	public void setPl_num(int pl_num) {
		this.pl_num = pl_num;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getPl_title() {
		return pl_title;
	}
	public void setPl_title(String pl_title) {
		this.pl_title = pl_title;
	}
	public Timestamp getPl_inDate() {
		return pl_inDate;
	}
	public void setPl_inDate(Timestamp pl_inDate) {
		this.pl_inDate = pl_inDate;
	}
	
	
}
