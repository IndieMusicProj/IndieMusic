package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.AdminDAO;
import com.indie.dto.AdminVO;

public class ManageAdminDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("뮤직 상세 컨트롤러 실행");
		String url = "/adminMode/admin/detailAdminForm.jsp";

		String adm_num = request.getParameter("adm_num");

		AdminDAO adminDAO = AdminDAO.getInstance();
		AdminVO adminInfo = adminDAO.getAdmin(Integer.parseInt(adm_num));

		request.setAttribute("selected", "admin");
		request.setAttribute("adminInfo", adminInfo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
