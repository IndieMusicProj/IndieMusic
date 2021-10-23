package com.indie.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.AdminDAO;
import com.indie.dto.AdminVO;

public class ManageAdminAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("관리자 계정 컨트롤러 실행");
		String url = "/adminMode/admin/manageAdmin.jsp";
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		ArrayList<AdminVO> adminInfoList = (ArrayList<AdminVO>) adminDAO.getAdminList();
		
		request.setAttribute("selected", "admin");
		request.setAttribute("adminInfoList", adminInfoList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
