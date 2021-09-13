package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indie.dto.BoardVO;

import util.DBManager;

public class PlaylistDAO {

	// SingleTornPattern
	private static PlaylistDAO instance = new PlaylistDAO();
	private PlaylistDAO() {
	}
	public static PlaylistDAO getInstance() {
		return instance;
	}

	// DBCP 객체 초기화
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;

// CRUD
	
// Read (List)
	// 담기 한 곡들 아이디 값을 매개값으로 받아오기
	
// Delete (delete)
	// 담기 된 곡 삭제 (담기 값 변경?)
	
	
}
