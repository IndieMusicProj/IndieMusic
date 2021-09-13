package com.indie.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;

public class ManageMusicDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/adminMode/manageMusicDetail.jsp";

		String m_id = request.getParameter("m_id");

		MusicDAO musicDAO = MusicDAO.getInstance();
		MusicVO musicVO = musicDAO.getMusic(Integer.parseInt(m_id));
		
		request.setAttribute("musicVO", musicVO);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
