package com.indie.controller.action.music;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;

public class RandomAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		String url = "music/randomAction.jsp";
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		MusicDAO musicDAO = MusicDAO.getInstance();
		musicDAO.updateCnt(id);
		
		int count = Integer.parseInt(request.getParameter("r_num"));
		String m_genre = request.getParameter("genre");
		System.out.println(count);
		System.out.println(m_genre);
		
		
		ArrayList<MusicVO> list = (ArrayList<MusicVO>) musicDAO.getRandomList(m_genre);
		
		Collections.shuffle(list);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
