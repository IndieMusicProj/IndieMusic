package com.indie.controller.action.playlist;

import java.io.IOException;
import java.util.ArrayList;

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

public class Playlist_DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Playlist_DeleteAction 실행");
		
		String url = "IndieServlet?command=Playlist_My_Form";
		
		HttpSession session = request.getSession();
		PlaylistDAO plDAO = PlaylistDAO.getInstance();
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		int pl_num = Integer.parseInt(request.getParameter("pl_num"));
		
		plDAO.deletePlaylist(pl_num);
		plDAO.deletePlaylistTable(loginUser.getMb_id(), pl_num);
		
		response.sendRedirect(url);
	}

}
