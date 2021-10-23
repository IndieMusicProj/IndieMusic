package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;

public class ManageMemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getContextPath() +"/IndieServlet?command=manage_member";
		
//		MemberVO memberVO = new MemberVO();
//		
//		MemberDAO memberDAO = MemberDAO.getInstance();
//
//		MemberVO.setM_id(Integer.parseInt(request.getParameter("m_id")));
//
//		
//		memberDAO.(musicVO);
//		
		response.sendRedirect(url);
	}

}
