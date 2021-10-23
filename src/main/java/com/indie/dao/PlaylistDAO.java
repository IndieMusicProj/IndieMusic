package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.indie.dto.MusicVO;
import com.indie.dto.PlaylistVO;

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

//CRUD
	
//Read 
	// 나의 플레이리스트불러오기
	public List<PlaylistVO> getPlaylistById(String mb_id) {
		// mb_id값 받아와 해당 id값을 가진 모든 컬럼 (title은 distinct:고유값출력) 받아옴
		ArrayList<PlaylistVO> my_playlist = new ArrayList<PlaylistVO>();
		String sql= "select * from playlist where mb_id = ? order by pl_num asc";
		
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, mb_id);
	      rs = pstmt.executeQuery();
	      
	      while (rs.next()) {
	    	  	PlaylistVO plVO = new PlaylistVO();	
	    	  	plVO.setPl_num(rs.getInt("PL_NUM"));
	    	  	plVO.setMb_id(rs.getString("MB_ID"));
	    	  	plVO.setPl_title(rs.getString("PL_TITLE"));
	    	  	plVO.setPl_inDate(rs.getTimestamp("PL_INDATE"));
				my_playlist.add(plVO);
	      }
		} catch (Exception e) {
		      e.printStackTrace();
		      System.out.println("getPlaylistById() 오류");
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}
		return my_playlist;
	}
	
	
//Read<List> 
	// 해당 플레이리스트에 해당하는 노래 정보들 불러오기
	public List<MusicVO> getPlaylistSongs(String mb_id,int pl_num) {
		List<MusicVO> playlist_songs = new ArrayList<MusicVO>();
		MusicVO musicVO = null;
		// 해당 테이블 검색, 모든 곡 정보 받아와서 해당 곡 정보들 조회
		String sql= "select * from music where music.m_id in (select m_id from \""+mb_id+"_"+pl_num+"\") ";
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      rs = pstmt.executeQuery();
	      
	      while (rs.next()) {
	    	  	musicVO = new MusicVO();
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
				playlist_songs.add(musicVO);
	      }
		} catch (Exception e) {
		      e.printStackTrace();
		      System.out.println("getPlaylistSongs() 오류");
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}
		return playlist_songs;
	}
	
//Create  
	//플레이리스트 생성// playlist 정보 담는 컬럼
	public void insertPlaylist(PlaylistVO plVO) {
		// num : pk로 구분
			//PlaylistVO plVO = new PlaylistVO();
			String sql = "insert into playlist "
					+ "values((SELECT NVL(MAX(pl_num), 0)+1 FROM playlist),?,?,to_timestamp(sysdate, 'YYYY-MM-DD'))";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, plVO.getMb_id());
				pstmt.setString(2, plVO.getPl_title());
				
				pstmt.executeUpdate();
				
				//result = rs.getInt("PL_NUM");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("insertPlaylist() 오류");
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	//Create  
		//플레이리스트 생성// playlist 정보 담는 컬럼
		public int getPlNumInPlaylist() {
			// num : pk로 구분
				//PlaylistVO plVO = new PlaylistVO();
				int result = 0;
				
				String getPl_Num = "select max(pl_num) from playlist";
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(getPl_Num);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						result = rs.getInt("max(pl_num)");
						System.out.println("해당 pl_num 값 :::::");
					}
					//result = rs.getInt("PL_NUM");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("getPlNumInPlaylist() 오류");
				} finally {
					DBManager.close(conn, pstmt,rs);
				}
				return result;
			}
//Create  
	//플레이리스트 생성// playlist 곡 정보 담는 테이블
	public void insertPlaylist_Music(String mb_id,int pl_num) {
		// num : pk로 구분
		String sql = "create table \""+mb_id+"_"+pl_num+"\" (\"PL_NUM\" NUMBER(8,2),\"M_ID\" NUMBER(8,2))";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertPlaylist_Music() 오류");
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
//Creat 
	// 플레이리스트에 해당 곡 담기 
	public void addPlaylist(String mb_id,int pl_num,int m_id) {
//		// 노래 담기버튼-> 플레이리스트 선택시 실행 메소드
		String sql = "insert into \""+mb_id+"_"+pl_num+"\" values(?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pl_num);
			pstmt.setInt(2, m_id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("addPlaylist() 오류");
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
//	public void addPlaylist(int m_id, String mb_id) {
//		// 노래 담기버튼-> 플레이리스트 선택시 실행 메소드
//		// pl_id,pl_id, pl_num, pl_num이 일치시 추가
//		// 해당 곡 정보-> playlist table 에 저장
//		String sql = "insert into playlist (PL_NUM, M_ID, MB_ID) values((SELECT NVL(MAX(playlist.pl_num), 0)+1 FROM playlist),?,?)";
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, m_id);
//			pstmt.setString(2, mb_id);
//			
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("insertBoard() 오류");
//		} finally {
//			DBManager.close(conn, pstmt);
//		}
//	}
	
//Read  
	// 플레이리스트 재생(전체 재생)
	public void playPlaylist() {
		// playlist play하는 메소드
	}
	
//Delete 
	// 해당 플레이리스트 삭제하기
	public void deletePlaylist(int pl_num) {
		String sql = "delete playlist where pl_num = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pl_num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("deletePlaylist() 오류");
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
//Delete 
	// 해당 플레이리스트의 곡 정보들 삭제하기
	public void deletePlaylistTable(String mb_id,int pl_num) {
		String sql = "drop table \""+mb_id+"_"+pl_num+"\" ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("deletePlaylist() 오류");
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
//Delete 
	// 해당 플레이리스트내 해당 곡 삭제
	public void deleteSongsInPlaylist(String mb_id,int pl_num,int m_id) { 
		// insert와 같은 원리, pl_id,pl_id, pl_num, pl_num이 일치시 해당 컬럼 삭제 
		String sql = "delete \""+mb_id+"_"+pl_num+"\" where m_id = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m_id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("deleteSongsInPlaylist() 오류");
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
	
	
	
}
