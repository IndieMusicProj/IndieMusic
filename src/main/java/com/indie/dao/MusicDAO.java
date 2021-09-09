package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.indie.dto.MusicVO;

import util.DBManager;

public class MusicDAO {
	private MusicDAO() {
		
	}
	private static MusicDAO instance = new MusicDAO();
	
	public static MusicDAO getInstance() {
		return instance;
	}
	
	public List<MusicVO> getAllPopular(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getKorPopular(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "kor");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getForPopular(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "for");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getAllNewest(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music order by m_indate desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getKorNewest(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? order by m_indate desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "kor");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getForNewest(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? order by m_indate desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "for");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getKorDanceGenre(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? and m_genre = ? order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "kor");
			pstmt.setString(2, "dan");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getForDanceGenre(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? and m_genre = ? order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "for");
			pstmt.setString(2, "dan");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getKorBalladGenre(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? and m_genre = ? order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "kor");
			pstmt.setString(2, "bal");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getForBalladGenre(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? and m_genre = ? order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "for");
			pstmt.setString(2, "bal");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getKorHiphopGenre(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? and m_genre = ? order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "kor");
			pstmt.setString(2, "hip");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getForHiphopGenre(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? and m_genre = ? order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "for");
			pstmt.setString(2, "hip");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getKorIndieGenre(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? and m_genre = ? order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "kor");
			pstmt.setString(2, "in");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	public List<MusicVO> getForIndieGenre(){
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_nation = ? and m_genre = ? order by m_playcnt desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "for");
			pstmt.setString(2, "in");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getString("M_ID"));
				musicVO.setM_genre(rs.getString("M_GENRE"));
				musicVO.setM_nation(rs.getString("M_NATION"));
				musicVO.setM_name(rs.getString("M_NAME"));
				musicVO.setM_artist(rs.getString("M_ARTIST"));
				musicVO.setM_album(rs.getString("M_ALBUM"));
				musicVO.setM_album_pic(rs.getString("M_ALBUM_PIC"));
				musicVO.setM_lyrics(rs.getString("M_LYRICS"));
				musicVO.setM_playcnt(rs.getInt("M_PLAYCNT"));
				musicVO.setM_indate(rs.getTimestamp("M_INDATE"));
				
				musicList.add(musicVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return musicList;
		
	}
	
	
	
//	public MusicVO getmusic() {
//		MusicVO vo = null;
//		String sql = "select * from music where m_id = ?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "1");
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				vo = new MusicVO();
//				vo.setM_name(rs.getString("m_name"));
//				vo.setM_artist(rs.getString("m_artist"));
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//		return vo;
//		
//	}
}
