package com.indie.controller.action.playlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.PlaylistDAO;
import com.indie.dto.MemberVO;
import com.indie.dto.MusicVO;
import com.indie.dto.PlaylistVO;

public class Playlist_Detail_FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Playlist_Detail_FormAction 실행");
		
		String url = "playlist/playlist_detail.jsp";
		
		HttpSession session = request.getSession();
		PlaylistDAO plDAO = PlaylistDAO.getInstance();
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		int pl_num = Integer.parseInt(request.getParameter("pl_num"));
		String pl_title = request.getParameter("pl_title");
		
		List<MusicVO> playlist_songs = plDAO.getPlaylistSongs(loginUser.getMb_id(), pl_num);
		
		request.setAttribute("pl_title", pl_title);
		request.setAttribute("pl_num", pl_num);
		request.setAttribute("playlist_songs", playlist_songs);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
