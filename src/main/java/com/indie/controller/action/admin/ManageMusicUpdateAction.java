package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;

public class ManageMusicUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getContextPath() +"/IndieServlet?command=manage_music";
				
		MusicVO mVo = new MusicVO();
		
		MusicDAO musicDAO = MusicDAO.getInstance();
		
		musicDAO.updateMusic(mVo);
		
		response.sendRedirect(url);
	}

}
