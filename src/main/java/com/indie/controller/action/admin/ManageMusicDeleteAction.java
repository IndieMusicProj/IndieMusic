package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;

public class ManageMusicDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("뮤직 삭제 컨트롤러 실행");
		String url = request.getContextPath()+"/IndieServlet?command=manage_music";

		String m_id = request.getParameter("m_id");

		MusicDAO musicDAO = MusicDAO.getInstance();
		musicDAO.deleteMusic(Integer.parseInt(m_id));

		response.sendRedirect(url);
	}

}
