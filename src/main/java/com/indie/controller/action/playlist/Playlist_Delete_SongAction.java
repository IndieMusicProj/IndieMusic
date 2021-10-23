package com.indie.controller.action.playlist;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.PlaylistDAO;
import com.indie.dto.MemberVO;

public class Playlist_Delete_SongAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Playlist_DeleteAction 실행");
		
//		String url = "playlist/playlist_detail.jsp";
//		String url = "location.reload()";
		
		HttpSession session = request.getSession();
		PlaylistDAO plDAO = PlaylistDAO.getInstance();
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		int pl_num = Integer.parseInt(request.getParameter("pl_num"));
		String pl_title = request.getParameter("pl_title");
		
//		int m_id = Integer.parseInt(request.getParameter("m_id"));
		String[] m_idArr = request.getParameterValues("m_id");
		
		for(String m_id : m_idArr) {
			System.out.println("플레이리스트에서 곡 삭제 요청 ::" + m_id);
			plDAO.deleteSongsInPlaylist(loginUser.getMb_id(), pl_num,Integer.parseInt(m_id));
		}
		
		String url = "IndieServlet?command=Playlist_Detail_Form&pl_num=" + pl_num + "&pl_title=" + pl_title;
		
		response.sendRedirect(url);
	}

}
