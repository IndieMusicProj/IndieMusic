package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.AdminDAO;
import com.indie.dto.AdminVO;

public class AdminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "adminMode/login_fail.html";

		HttpSession session = request.getSession();

		String adm_id = request.getParameter("adm_id");
		String adm_pwd = request.getParameter("adm_pwd");

		AdminVO adminVO = new AdminVO();
		
		adminVO.setAdm_id(adm_id);
		adminVO.setAdm_pwd(adm_pwd);
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		AdminVO loginAdmin = adminDAO.loginAdmin(adminVO);

		if (loginAdmin != null) {
			if (loginAdmin.getAdm_pwd().equals(adm_pwd)) {
				session.removeAttribute("adm_id");
				session.setAttribute("loginAdmin", loginAdmin);
				url = request.getContextPath()+"/adminMode/adminIndex.jsp";
			}
		}
		response.sendRedirect(url);

	}

}
