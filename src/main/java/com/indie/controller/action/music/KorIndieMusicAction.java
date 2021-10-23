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

public class KorIndieMusicAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		String url = "/music/korInChart.jsp";
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		MusicDAO musicDAO = MusicDAO.getInstance();
		musicDAO.updateCnt(id);
		
		ArrayList<MusicVO> getKorIndieGenre = (ArrayList<MusicVO>) musicDAO.getKorIndieGenre();
		
		request.setAttribute("getKorIndieGenre", getKorIndieGenre);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
