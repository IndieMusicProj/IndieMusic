package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.indie.dto.AdminVO;

import util.DBManager;

public class AdminDAO {

	private AdminDAO() {
	}

	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	/*
	 * * 관리자 페이지에서 사용되는 메소드 * *
	 */

	// admin 로그인
	public int loginAdmin(AdminVO adminVO) {
		int result = -1;
		String sql = "select * from admin where adm_id=? and adm_pwd=?";

		Connection connn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connn = DBManager.getConnection();
			pstmt = connn.prepareStatement(sql);
			pstmt.setString(1, adminVO.getAdm_id());
			pstmt.setString(2, adminVO.getAdm_pwd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// -1이면 로그인 실패 1이면 로그인 성공
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connn, pstmt, rs);
		}
		return result;
	}

	// admin 계정 생성
	public int insertAdmin(AdminVO adminVO) {
		int result = -1;
		String sql = "insert into member(adm_id, adm_pwd, adm_email, adm_auth) values(?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminVO.getAdm_id());
			pstmt.setString(2, adminVO.getAdm_pwd());
			pstmt.setString(3, adminVO.getAdm_email());
			pstmt.setString(4, adminVO.getAdm_auth());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	// admin 정보 가져오기
	public AdminVO getAdmin(String id) {
		AdminVO adminVO = null;
		String sql = "select * from admin where adm_id=?";

		Connection connn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connn = DBManager.getConnection();
			pstmt = connn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				adminVO = new AdminVO();
				adminVO.setAdm_num(rs.getInt("adm_num"));
				adminVO.setAdm_id(rs.getString("adm_id"));
				adminVO.setAdm_pwd(rs.getString("adm_pwd"));
				adminVO.setAdm_email(rs.getString("adm_email"));
				adminVO.setAdm_auth(rs.getString("adm_auth"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connn, pstmt, rs);
		}
		return adminVO;
	}

	// admin 계정 수정
	public void updateAdmin(AdminVO bVo) {
		String sql = "UPDATE admin SET adm_id=?, adm_pwd=?, adm_email=?, adm_auth=? WHERE adm_num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getAdm_id());
			pstmt.setString(2, bVo.getAdm_pwd());
			pstmt.setString(3, bVo.getAdm_email());
			pstmt.setString(4, bVo.getAdm_auth());
			pstmt.setInt(5, bVo.getAdm_num());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// admin 계정 삭제
	public void deleteAdmin(int adm_num) {
		String sql = "DELETE admin WHERE adm_num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adm_num);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}


}
