package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.AdminDAO;
import com.indie.dto.AdminVO;

public class AdminIndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "adminMode/login_fail.html";

		HttpSession session = request.getSession();

		String adm_id = request.getParameter("adm_id");
		String adm_pwd = request.getParameter("adm_pwd");

		AdminDAO adminDAO = AdminDAO.getInstance();
		AdminVO adminVO = adminDAO.getAdmin(adm_id);

		if (adminVO != null) {
			if (adminVO.getAdm_pwd().equals(adm_pwd)) {
				session.removeAttribute("adm_id");
				session.setAttribute("adminVO", adminVO);
				url = "IndieServlet?command=admin_index";
			}
		}
		response.sendRedirect(url);

	}

}
