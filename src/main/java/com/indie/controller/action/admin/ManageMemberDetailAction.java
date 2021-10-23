package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;
import com.indie.dto.MemberVO;

public class ManageMemberDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("뮤직 상세 컨트롤러 실행");
		String url = "/adminMode/member/detailMemberForm.jsp";

		String mb_id = request.getParameter("mb_id");

		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberInfo = memberDAO.getMember(mb_id);

		request.setAttribute("selected", "member");
		request.setAttribute("memberInfo", memberInfo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
