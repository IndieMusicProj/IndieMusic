package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indie.dto.BoardVO;
import com.indie.dto.PageVO;

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

// Paing  페이지 번호 부여
	
	
	
// CRUD
// Create (insert)
	// 게시글 저장
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board (b_num, adm_num, b_title, b_category, b_content,b_picture)"
				+ "values((SELECT NVL(MAX(board.b_num), 0)+1 FROM BOARD),?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getAdm_num());
			pstmt.setString(2, vo.getB_title());
			pstmt.setString(3, vo.getB_category());
			pstmt.setString(4, vo.getB_content());
			pstmt.setString(5, vo.getB_picture());
			System.out.println("사진이름 ㅇㄸ릉나ㅣㅁ서ㅗ"+vo.getB_picture());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
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
				vo.setAdm_num(rs.getInt("adm_num"));
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
	// 전체 게시글 최신순 정렬 // paing
		public ArrayList<BoardVO> getBoardListByNewest() { //(main 페이지에 들어감)
			String sql= "select * from board order by b_regdate desc";
			 ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
			try {
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
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
			      System.out.println("getBoardListByNewest() 오류");
			} finally {
			  DBManager.close(conn, pstmt, rs);
			}
			return boardList;	
		}
		
	// 전체 게시글 최신순 정렬 // paing
	public ArrayList<BoardVO> getBoardListByNewestPaging(PageVO paging) { //(main 페이지에 들어감)
		// 1번 페이지 1~10
		// 2번 페이지 11~20
		int startNum = (paging.getPage() - 1) * 5 + 1;
		int endNum = paging.getPage() * 5;
//		int startNum = paging.getStartNum();
//	    int endNum = paging.getEndNum();
	    
		 String sql = "SELECT * FROM ("
	                + "SELECT * FROM ("
	                + "SELECT ROWNUM row_num, board.* FROM board"
	                + ") WHERE row_num >= ?"
	                + ") WHERE row_num <= ? order by b_regdate desc";
//		String sql= "select * from board order by b_regdate desc";
		 ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, startNum);
	      pstmt.setInt(2, endNum);
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
		      System.out.println("getBoardListByNewestPaging() 오류");
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}
		return boardList;	
	}
	
// Read (List)
	// 게시글 카테고리별 출력 
	public ArrayList<BoardVO> getBoardListByCategory(String category) { //(매개값 : 카테고리)
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		
		String sql= "select * from board where b_category=? order by b_regdate";
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, category);
	      rs = pstmt.executeQuery();
	      
	      while (rs.next()) {
		    	BoardVO vo = new BoardVO();
		    	vo.setB_num(rs.getInt("b_num"));
		    	vo.setAdm_num(rs.getInt("adm_num"));
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
		
	// 게시글 카테고리별 출력  // paing
		public ArrayList<BoardVO> getBoardListByCategoryPaging(String category,PageVO paging) { //(매개값 : 카테고리)
			// 1번 페이지 1~10
			// 2번 페이지 11~20
			int startNum = (paging.getPage() - 1) * 5 + 1;
			int endNum = paging.getPage() * 5;
//			int startNum = paging.getStartNum();
//		    int endNum = paging.getEndNum();
		    
			 String sql = "SELECT * FROM ("
		                + "SELECT * FROM ("
		                + "SELECT ROWNUM row_num, board.* FROM board where b_category=?"
		                + ") WHERE row_num >= ?"
		                + ") WHERE row_num <= ? order by b_regdate desc";
//			String sql= "select * from board order by b_regdate desc";
			 ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
			try {
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, category);
		      pstmt.setInt(2, startNum);
		      pstmt.setInt(3, endNum);
		      rs = pstmt.executeQuery();
		      
		      while (rs.next()) {
		    	  	BoardVO vo = new BoardVO();
			    	vo.setB_num(rs.getInt("b_num"));
			    	vo.setAdm_num(rs.getInt("adm_num"));
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
			      System.out.println("getBoardListByCategoryPaging() 오류");
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
		}
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
				e.printStackTrace();
				System.out.println("deleteBoard() 오류");
			} finally {
				DBManager.close(conn, pstmt);
			}
	}
	
	// 모든 게시글 개수 출력
	public int getAllCount() {
		 String sql = "SELECT COUNT(*) as count FROM board";
		    int count = 0;
		    try{
		    	conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
		        rs= pstmt.executeQuery();
		        if(rs.next()){
		            count = rs.getInt("count");
		        }
		    }catch(Exception e){
		        e.printStackTrace();
		    }finally{
		        DBManager.close(conn, pstmt, rs);
		    }
		    return count;
	}
	
	// 카테고리별 게시글 갯수 출ㄹㅕㄱ
	public int getCategoryCount(String category) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) as count FROM board where b_category=? ";
	    int count = 0;
	    try{
	    	conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
	        rs= pstmt.executeQuery();
	        if(rs.next()){
	            count = rs.getInt("count");
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }finally{
	        DBManager.close(conn, pstmt, rs);
	    }
	    return count;
	}
	
	
	
	
	
	
}
