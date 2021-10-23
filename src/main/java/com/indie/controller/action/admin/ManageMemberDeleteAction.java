package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;

public class ManageMemberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("뮤직 삭제 컨트롤러 실행");
		String url ="/IndieServlet?command=manage_member";

		String mb_num = request.getParameter("mb_num");

		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.deleteMember(Integer.parseInt(mb_num));

		request.getRequestDispatcher(url).forward(request, response);
	}

}
