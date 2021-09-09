package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;

public class InsertMusicFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getContextPath()+"/adminMode/InsertMusicForm.jsp";
		
		response.sendRedirect(url);
	}

}
