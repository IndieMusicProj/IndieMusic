package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.AdminDAO;
import com.indie.dto.AdminVO;

public class ManageAdminInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("관리자 계정 등록 컨트롤러 실행");
		String url = "/IndieServlet?command=manage_admin";
		
		AdminVO adminVO = new AdminVO();
		
		adminVO.setAdm_id(request.getParameter("adm_id"));
		adminVO.setAdm_pwd(request.getParameter("adm_pwd"));
		adminVO.setAdm_email(request.getParameter("adm_email"));
		adminVO.setAdm_auth(Integer.parseInt(request.getParameter("adm_auth")));
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		adminDAO.insertAdmin(adminVO);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
