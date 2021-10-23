package com.indie.controller.action.music;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;

public class LyricsDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		String url = "/music/lyricsDetail.jsp";
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		
		MusicDAO musicDAO = MusicDAO.getInstance();
		MusicVO musicVO = musicDAO.getMusic(m_id);
		
		request.setAttribute("musicInfo", musicVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
