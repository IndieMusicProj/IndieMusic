package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;

public class ManageMusicInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("뮤직 등록 컨트롤러 실행");
		String url = "/IndieServlet?command=manage_music";
		
		MusicVO musicVO = new MusicVO();
		
		musicVO.setM_name(request.getParameter("m_name"));
		musicVO.setM_artist(request.getParameter("m_artist"));
		musicVO.setM_nation(request.getParameter("m_nation"));
		musicVO.setM_album(request.getParameter("m_album"));
		musicVO.setM_album_pic(request.getParameter("m_album_pic")!=null?request.getParameter("m_album_pic"):"noimg.png");
		musicVO.setM_genre(request.getParameter("m_genre"));
		musicVO.setM_lyrics(request.getParameter("m_lyrics")!=null?request.getParameter("m_lyrics"):"가사 없음");

		MusicDAO musicDAO = MusicDAO.getInstance();
		musicDAO.InsertMusic(musicVO);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
