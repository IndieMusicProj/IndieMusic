package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.indie.dto.BoardVO;

public class BoardDAO {

	// SingleTornPattern
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {
	}
	public static BoardDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	// Create (insert)
	// BoardVO 를 매개값으로 받아 DB에 저장.
	public void board_insert(BoardVO vo) {
		String sql = "insert into board values(?,?,?,?)";
	}
	
	// Read (Detail)
	public BoardVO board_get(BoardVO vo) {
		return null;
	}
	
	// Read (List)
	public List<BoardVO> board_getList(BoardVO vo) {
		return null;
	}
	
	// Update (update)
	public void board_update(BoardVO vo) {
		
	}
	
	// Delete (delete)
	public void board_delete(BoardVO vo) {
		
	}
	
	
	
	
	
	
	
}
