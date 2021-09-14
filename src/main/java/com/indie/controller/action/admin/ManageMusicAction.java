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

public class ManageMusicAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("노래 관리 컨트롤러 실행");
		String url = "/adminMode/music/manageMusic.jsp";
		
		MusicDAO musicDAO = MusicDAO.getInstance();
		
		ArrayList<MusicVO> musicInfoList = (ArrayList<MusicVO>) musicDAO.getMusicList();
		
		request.setAttribute("selected", "music");
		request.setAttribute("musicInfoList", musicInfoList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
