
package com.indie.dto;

import java.sql.Date;

public class BoardVO {

	// admin_id (관리자 id로 로그인시 수정 가능)
	
	private int boardNum; // 글 번호 (primary key, sequence) // 수정 불가
	private String category; // 글 종류 (분류)
	private String title; // 글 제목
	private String content; // 내용
	private int readCnt; // 조회수 // 수정 불가 예정
	private Date regDate; // 글 등록일
	
	// artist 사진, 노래들. 추가예정
	// 0909(목) 수업 후 검색기능 도입 예정
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
}
