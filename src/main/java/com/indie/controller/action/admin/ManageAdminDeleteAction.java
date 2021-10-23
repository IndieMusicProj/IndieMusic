package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.AdminDAO;

public class ManageAdminDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("관리자 계정 삭제 컨트롤러 실행");
		String url = request.getContextPath()+"/IndieServlet?command=manage_admin";

		String adm_num = request.getParameter("adm_num");

		AdminDAO adminDAO = AdminDAO.getInstance();
		adminDAO.deleteAdmin(Integer.parseInt(adm_num));

		response.sendRedirect(url);
	}

}
