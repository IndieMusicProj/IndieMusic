package com.indie.dto;

import java.sql.Timestamp;

public class MusicVO {
	private String m_id;
	private String m_genre;
	private String m_nation;
	private String m_name;
	private String m_artist;
	private String m_album;
	private String m_album_pic;
	private String m_lyrics;
	private int m_playcnt;
	private Timestamp m_indate;
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_genre() {
		return m_genre;
	}
	public void setM_genre(String m_genre) {
		this.m_genre = m_genre;
	}
	public String getM_nation() {
		return m_nation;
	}
	public void setM_nation(String m_nation) {
		this.m_nation = m_nation;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_artist() {
		return m_artist;
	}
	public void setM_artist(String m_artist) {
		this.m_artist = m_artist;
	}
	public String getM_album() {
		return m_album;
	}
	public void setM_album(String m_album) {
		this.m_album = m_album;
	}
	public String getM_album_pic() {
		return m_album_pic;
	}
	public void setM_album_pic(String m_album_pic) {
		this.m_album_pic = m_album_pic;
	}
	public String getM_lyrics() {
		return m_lyrics;
	}
	public void setM_lyrics(String m_lyrics) {
		this.m_lyrics = m_lyrics;
	}
	public int getM_playcnt() {
		return m_playcnt;
	}
	public void setM_playcnt(int m_playcnt) {
		this.m_playcnt = m_playcnt;
	}
	public Timestamp getM_indate() {
		return m_indate;
	}
	public void setM_indate(Timestamp m_indate) {
		this.m_indate = m_indate;
	}
}
