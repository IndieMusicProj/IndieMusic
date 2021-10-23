package com.indie.controller.action.playlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dao.PlaylistDAO;
import com.indie.dto.BoardVO;
import com.indie.dto.MemberVO;
import com.indie.dto.PlaylistVO;

public class Playlist_Insert_FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Playlist_Insert_FormAction 실행");
		
		String url = "playlist/playlist_insert_form.jsp";
		
		// 현재 나의 플레이리스트 목록(My_Playlist)
		
		HttpSession session = request.getSession();
		PlaylistDAO plDAO = PlaylistDAO.getInstance();
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		// 없을 시 로그인 화면.
		
		List<PlaylistVO> my_playlist = plDAO.getPlaylistById(loginUser.getMb_id());
		
		request.setAttribute("my_playlist", my_playlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
