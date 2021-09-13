package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indie.dto.BoardVO;

import util.DBManager;

public class BoardDAO {

	// SingleTornPattern
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {
	}
	public static BoardDAO getInstance() {
		return instance;
	}

	// DBCP 객체 초기화
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;

// CRUD
// Create (insert)
	// 게시글 저장
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board (b_num, b_category, b_title, b_content)"
				+ "values((SELECT NVL(MAX(board.b_num), 0)+1 FROM BOARD),?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getB_num());
			pstmt.setString(2, vo.getB_category());
			pstmt.setString(3, vo.getB_title());
			pstmt.setString(4, vo.getB_content());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertBoard() 오류");
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
// Read (Detail)
	// 게시글 상세보기
	public BoardVO getBoard(int b_num) { // (매개값 : 게시글 번호)
		String sql = "select * from board where b_num =" + b_num;
		BoardVO vo = new BoardVO();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo.setB_num(rs.getInt("b_num"));
				vo.setB_picture(rs.getString("b_picture"));
				vo.setB_category(rs.getString("b_category"));
				vo.setB_title(rs.getString("b_title"));
				vo.setB_content(rs.getString("b_content"));
				vo.setB_readCnt(rs.getInt("b_readCnt"));
	    	  	vo.setB_regDate(rs.getTimestamp("b_regDate"));
	    	  	vo.setB_upDate(rs.getTimestamp("b_upDate"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getBoard() 오류");
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
// Read (List)
	// 전체 게시글 최신순 정렬 
	public ArrayList<BoardVO> getBoardListByNewest(BoardVO vo) { //(main 페이지에 들어감)
			
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		String sql= "select * from board order by b_regDate asc";
		
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      rs = pstmt.executeQuery();
	      
	      while (rs.next()) {
	    	  	BoardVO boardVO = new BoardVO();	
	    	  	boardVO.setB_num(rs.getInt("b_num"));
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
		      System.out.println("getBoardListByNewest() 오류");
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}
		return boardList;	
	}
	
// Read (List)
	// 게시글 카테고리별 출력 
	public ArrayList<BoardVO> getBoardListByCategory(String category) { //(매개값 : 카테고리)
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		
		String sql= "select * from board where b_category=? order by b_regDate asc";
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, category);
	      rs = pstmt.executeQuery();
	      
	      while (rs.next()) {
		    	BoardVO vo = new BoardVO();
		    	vo.setB_num(rs.getInt("b_num"));
	    	  	vo.setB_picture(rs.getString("b_picture"));
	    	  	vo.setB_category(rs.getString("b_category"));
				vo.setB_title(rs.getString("b_title"));
				vo.setB_content(rs.getString("b_content"));
				vo.setB_readCnt(rs.getInt("b_readCnt"));
				vo.setB_regDate(rs.getTimestamp("b_regDate"));
				vo.setB_upDate(rs.getTimestamp("b_upDate"));
				boardList.add(vo);
	      }
		} catch (Exception e) {
		      e.printStackTrace();
		      System.out.println("getBoardListByCategory() 오류");
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}
		return boardList;	
	}
		
		
// Update (update)
	// 게시글 수정 
	public void updateBoard(BoardVO vo) { // (매개값 : vo객체)
		String sql = "update board set b_category=?, b_title=?, b_content=?, b_update=SYSTIMESTAMP where b_num=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getB_category());
			pstmt.setString(2, vo.getB_title());
			pstmt.setString(3, vo.getB_content());
			pstmt.setInt(4, vo.getB_num());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateBoard() 오류");
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
// Update (update)
	//조회수 업데이트 
	public void setReadCountUpdate(int b_num) { //(매개값 : 게시글 번호)
		String sql = "update board set b_readCnt = b_readCnt + 1 where b_num = " + b_num;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("setReadCountUpdate() 오류");
		}finally {
			DBManager.close(conn, pstmt);
		}//finally
	}
	
// Delete (delete)
	// 게시글 삭제 
	public void deleteBoard(int b_num) { //(매개값 : 게시글 번호)
		  String sql = "delete board where b_num = " + b_num;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("deleteBoard() 오류");
			} finally {
				DBManager.close(conn, pstmt);
			}
	}
	
	
	
	
	
	
}
