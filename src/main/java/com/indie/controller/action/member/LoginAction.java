package com.indie.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;
import com.indie.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getContextPath() + "/member/login_fail.jsp";
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + pwd);
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberVO = memberDAO.getMember(id);

		if (memberVO != null) {
			if (memberVO.getMb_pwd().equals(pwd)) {
				session.removeAttribute("id");
				session.setAttribute("loginUser", memberVO);
				url = request.getContextPath() + "/IndieServlet?command=index";
				System.out.println(url);
			}
		}

		response.sendRedirect(url);
	}

}
