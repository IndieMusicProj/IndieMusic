package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indie.dto.AdminVO;
import com.indie.dto.BoardVO;
import com.indie.dto.MemberVO;
import com.indie.dto.MusicVO;
import com.indie.dto.SearchVO;

import util.DBManager;

public class SearchDAO {

	private SearchDAO() {
	}

	private static SearchDAO instance = new SearchDAO();

	public static SearchDAO getInstance() {
		return instance;
	}

	public ArrayList<MemberVO> searchKeywordInMember(SearchVO searchVO) {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		String sql = "SELECT * FROM member WHERE mb_name||mb_id like '%'||?||'%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getSearchKeyword());
			System.out.println(searchVO.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setMb_num(rs.getInt("mb_num"));
				memberVO.setMb_id(rs.getString("mb_id"));
				memberVO.setMb_pwd(rs.getString("mb_pwd"));
				memberVO.setMb_name(rs.getString("mb_name"));
				memberVO.setMb_email(rs.getString("mb_email"));
				memberVO.setMb_zipNum(rs.getString("mb_zipnum"));
				memberVO.setMb_address(rs.getString("mb_address"));
				memberVO.setMb_mobile(rs.getString("mb_mobile"));
				memberVO.setMb_indate(rs.getTimestamp("mb_indate"));
				memberList.add(memberVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return memberList;
	}
	
	public ArrayList<MusicVO> searchKeywordInMusic(SearchVO searchVO) {
		ArrayList<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "SELECT * FROM music WHERE m_name||m_artist||m_lyrics like '%'||?||'%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getSearchKeyword());
			System.out.println(searchVO.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MusicVO musicVO = new MusicVO();
				musicVO.setM_id(rs.getInt("M_ID"));
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return musicList;

	}
	
	public ArrayList<BoardVO> searchKeywordInBoard(SearchVO searchVO) {
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		String sql = "SELECT * FROM board WHERE b_num||b_title||b_content like '%'||?||'%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getSearchKeyword());
			System.out.println(searchVO.toString());
			rs = pstmt.executeQuery();
	      
	      while (rs.next()) {
	    	  	BoardVO boardVO = new BoardVO();	
	    	  	boardVO.setB_num(rs.getInt("b_num"));
	    	  	boardVO.setAdm_num(rs.getInt("adm_num"));
	    	  	boardVO.setB_picture(rs.getString("b_picture"));
	    	  	boardVO.setB_category(rs.getString("b_category"));
	    	  	boardVO.setB_title(rs.getString("b_title"));
	    	  	boardVO.setB_content(rs.getString("b_content"));
	    	  	boardVO.setB_readCnt(rs.getInt("b_readCnt"));
				boardVO.setB_regDate(rs.getTimestamp("b_regDate"));
				boardVO.setB_upDate(rs.getTimestamp("b_upDate"));
				boardList.add(boardVO);
	      }
		} catch (Exception e) {
		      e.printStackTrace();
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}
		return boardList;	
	
	}
	
	public ArrayList<AdminVO> searchKeywordInAdmin(SearchVO searchVO) {
		ArrayList<AdminVO> adminList = new ArrayList<AdminVO>();
		String sql = "SELECT * FROM admin WHERE adm_id||adm_num like '%'||?||'%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getSearchKeyword());
			System.out.println(searchVO.toString());
			rs = pstmt.executeQuery();

			rs = pstmt.executeQuery();
			while (rs.next()) {
				AdminVO adminVO = new AdminVO();
				adminVO.setAdm_num(rs.getInt("adm_num"));
				adminVO.setAdm_id(rs.getString("adm_id"));
				adminVO.setAdm_pwd(rs.getString("adm_pwd"));
				adminVO.setAdm_email(rs.getString("adm_email"));
				adminVO.setAdm_auth(rs.getInt("adm_auth"));
				adminList.add(adminVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return adminList;
	}
}
