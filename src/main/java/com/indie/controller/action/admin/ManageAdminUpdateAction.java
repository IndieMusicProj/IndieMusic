package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.AdminDAO;
import com.indie.dto.AdminVO;

public class ManageAdminUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/IndieServlet?command=manage_admin";
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		AdminVO adminVO = new AdminVO();
		
		adminVO.setAdm_num(Integer.parseInt(request.getParameter("adm_num")));
		adminVO.setAdm_id(request.getParameter("adm_id"));
		adminVO.setAdm_pwd(request.getParameter("adm_pwd"));
		adminVO.setAdm_email(request.getParameter("adm_email"));
		adminVO.setAdm_auth(Integer.parseInt(request.getParameter("adm_auth")));
		
		adminDAO.updateAdmin(adminVO);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
