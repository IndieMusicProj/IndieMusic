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
import com.indie.dto.PlaylistVO;

public class Playlist_InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Playlist_InsertAction 실행");
		
		
		HttpSession session = request.getSession();
		PlaylistDAO plDAO = PlaylistDAO.getInstance();
		PlaylistVO plVO = new PlaylistVO();
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		String url = "IndieServlet?command=Playlist_My_Form";
		
		String pl_title = request.getParameter("pl_title");
		
		plVO.setMb_id(loginUser.getMb_id());
		plVO.setPl_title(pl_title);
		System.out.println("========== :: plVO getMb_id :: "+plVO.getMb_id());
		System.out.println("========== :: plVO pl_title :: "+plVO.getPl_title());
		
		plDAO.insertPlaylist(plVO);
		int pl_num = plDAO.getPlNumInPlaylist();
//		int pl_num = get_pl_num.getPl_num();
		System.out.println(pl_num);
		plDAO.insertPlaylist_Music(loginUser.getMb_id(), pl_num);
		
		response.sendRedirect(url);
	}

}
