package com.indie.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;
import com.indie.dto.MemberVO;

public class ManageMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원 관리 컨트롤러 실행");
		String url = "/adminMode/member/manageMember.jsp";
		System.out.println(url);
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		ArrayList<MemberVO> memberInfoList = (ArrayList<MemberVO>) memberDAO.getMemberList();
		
		request.setAttribute("selected", "member");
		request.setAttribute("memberInfoList", memberInfoList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
