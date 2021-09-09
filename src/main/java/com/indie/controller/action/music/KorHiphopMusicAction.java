package com.indie.controller.action.music;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;

public class KorHiphopMusicAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		String url = "/music/korHipChart.jsp";
		
		MusicDAO musicDAO = MusicDAO.getInstance();
		
		ArrayList<MusicVO> getKorHiphopGenre = (ArrayList<MusicVO>) musicDAO.getKorHiphopGenre();
		
		request.setAttribute("getKorHiphopGenre", getKorHiphopGenre);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
