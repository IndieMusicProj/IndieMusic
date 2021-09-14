package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indie.dto.MemberVO;

import util.DBManager;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public int confirmID(String userid) {

		String sql = "select * from member where mb_id = ?";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;
	}

	public int insertMember(MemberVO memberVO) {
		int result = 0;

		String sql = "insert into member(mb_num,mb_id, mb_pwd, mb_name, mb_zipnum,";
		sql += " mb_address, mb_mobile) values((SELECT NVL(MAX(board.b_num), 0)+1 FROM BOARD),?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberVO.getMb_id());
			pstmt.setString(2, memberVO.getMb_pwd());
			pstmt.setString(3, memberVO.getMb_name());
			pstmt.setString(4, memberVO.getMb_zipNum());
			pstmt.setString(5, memberVO.getMb_address());
			pstmt.setString(6, memberVO.getMb_mobile());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public MemberVO getMember(String mb_id) {
		String sql = "select * from member where mb_id = ?";
		MemberVO memberVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMb_num(rs.getInt("mb_num"));
				memberVO.setMb_id(rs.getString("mb_id"));
				memberVO.setMb_pwd(rs.getString("mb_pwd"));
				memberVO.setMb_name(rs.getString("mb_name"));
				memberVO.setMb_email(rs.getString("mb_email"));
				memberVO.setMb_zipNum(rs.getString("mb_zipnum"));
				memberVO.setMb_address(rs.getString("mb_address"));
				memberVO.setMb_mobile(rs.getString("mb_mobile"));
				memberVO.setMb_indate(rs.getTimestamp("mb_indate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return memberVO;
	}

	// 검색용
	public ArrayList<MemberVO> listMember(String member_name) {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		String sql = "select * from member where name like '%'||?||'%' " +
				"order by indate desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (member_name == "") {
				pstmt.setString(1, "%");
			} else {
				pstmt.setString(1, member_name);
			}
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
	
	// 관리자 회원 조회용
	public ArrayList<MemberVO> getMemberList() {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		String sql = "select * from member order by mb_indate desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
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
}
