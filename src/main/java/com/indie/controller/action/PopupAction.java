package com.indie.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;

public class PopupAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/main_popup.jsp";
		
		MusicDAO musicDAO = MusicDAO.getInstance();
		
		MusicVO lastMusic = musicDAO.getLast();
		request.setAttribute("lastMusic", lastMusic);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}

}
