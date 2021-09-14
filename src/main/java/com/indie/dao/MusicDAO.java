package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.indie.dto.BoardVO;
import com.indie.dto.MusicVO;

import util.DBManager;

public class MusicDAO {
	private MusicDAO() {

	}

	private static MusicDAO instance = new MusicDAO();

	public static MusicDAO getInstance() {
		return instance;
	}

	public List<MusicVO> getIndexPopular() {
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from (select * from music order by m_playcnt desc) where rownum <= 10";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
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

	public List<MusicVO> getAllPopular() {
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music order by m_playcnt desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
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

	public List<MusicVO> getKorPopular() {
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

	public List<MusicVO> getForPopular() {
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

	public List<MusicVO> getAllNewest() {
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music order by m_indate desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
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

	public List<MusicVO> getKorNewest() {
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

	public List<MusicVO> getForNewest() {
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

	public List<MusicVO> getAllDanceGenre() {
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_genre = ? order by m_playcnt desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "dan");
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

	public List<MusicVO> getAllBalladGenre() {
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_genre = ? order by m_playcnt desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "bal");
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

	public List<MusicVO> getAllHiphopGenre() {
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_genre = ? order by m_playcnt desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "hip");
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

	public List<MusicVO> getAllIndieGenre() {
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from music where m_genre = ? order by m_playcnt desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "in");
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

	public List<MusicVO> getKorDanceGenre() {
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

	public List<MusicVO> getForDanceGenre() {
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

	public List<MusicVO> getKorBalladGenre() {
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

	public List<MusicVO> getForBalladGenre() {
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

	public List<MusicVO> getKorHiphopGenre() {
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

	public List<MusicVO> getForHiphopGenre() {
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

	public List<MusicVO> getKorIndieGenre() {
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

	public List<MusicVO> getForIndieGenre() {
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

//  1. 음악 리스트 받기
	public List<MusicVO> getMusicList() {
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		String sql = "select * from (select * from music order by m_playcnt desc) order by m_id desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
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

//	2. 음악 상세정보 받기
	public MusicVO getMusic(int m_id) {
		MusicVO musicVO = null;
		String sql = "select * from music where m_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
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
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return musicVO;

	}

//	3. 음악 추가 
	public void InsertMusic(MusicVO mVo) {
		String sql = "insert into music(m_id, m_genre, m_nation, m_name, m_artist, m_album, m_album_pic, m_lyrics, m_playcnt)"
				+ " values((SELECT NVL(MAX(music.m_id), 0)+1 FROM music), ?, ?, ?, ?, ?, ?, ?, 0)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getM_genre());
			pstmt.setString(2, mVo.getM_nation());
			pstmt.setString(3, mVo.getM_name());
			pstmt.setString(4, mVo.getM_artist());
			pstmt.setString(5, mVo.getM_album());
			pstmt.setString(6, mVo.getM_album_pic());
			pstmt.setString(7, mVo.getM_lyrics());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

//	4. 음악 수정
	public void updateMusic(MusicVO mVo) {
		String sql = "update music set m_genre=?, m_nation=?, m_name=?, m_artist=?, m_album=?, m_album_pic=?, m_lyrics=? where m_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getM_genre());
			pstmt.setString(2, mVo.getM_nation());
			pstmt.setString(3, mVo.getM_name());
			pstmt.setString(4, mVo.getM_artist());
			pstmt.setString(5, mVo.getM_album());
			pstmt.setString(6, mVo.getM_album_pic());
			pstmt.setString(7, mVo.getM_lyrics());
			pstmt.setInt(8, mVo.getM_id());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateBoard() 오류");
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

//	5. 음악 삭제
	public void deleteMusic(int m_id) {
		String sql = "delete music where m_id = " + m_id;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}
