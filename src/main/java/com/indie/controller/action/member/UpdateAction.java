package com.indie.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;
import com.indie.dto.MemberVO;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getContextPath() + "/IndieServlet?command=index";
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String mobile = request.getParameter("mobile");
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.updateMember(pwd, mobile, id);
		
		MemberVO memberVO = memberDAO.getMember(id);
		session.setAttribute("loginUser", memberVO);

		response.sendRedirect(url);
	}

}
