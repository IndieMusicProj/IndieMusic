package com.indie.controller.action.playlist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;
import com.indie.dao.PlaylistDAO;
import com.indie.dto.MemberVO;

public class Add_Song_PlaylistAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("Add_Song_PlaylistAction 실행");
		String url = "";
		HttpSession session = request.getSession();
		
		int m_id = Integer.parseInt(request.getParameter("m_id"));
	// 	String list = request.getParameter("list");
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "IndieServlet?command=login";
		}else {
			int pl_num = Integer.parseInt(request.getParameter("pl_num"));
			PlaylistDAO plDAO = PlaylistDAO.getInstance();
			plDAO.addPlaylist(loginUser.getMb_id(), pl_num, m_id);
			url = "playlist/playlist_addSuccess.jsp";
		}
		
		response.sendRedirect(url);
	}

}
