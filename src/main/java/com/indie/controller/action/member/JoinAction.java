package com.indie.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;
import com.indie.dto.MemberVO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		
		HttpSession session= request.getSession();
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMb_id(request.getParameter("id"));
		memberVO.setMb_pwd(request.getParameter("pwd"));
	    memberVO.setMb_name(request.getParameter("name"));
	    memberVO.setMb_email(request.getParameter("email"));
	    memberVO.setMb_zipNum(request.getParameter("zipNum"));
	    memberVO.setMb_address(request.getParameter("addr1") + request.getParameter("addr2"));
	    memberVO.setMb_mobile(request.getParameter("mobile"));  
	    
	    MemberDAO memberDAO = MemberDAO.getInstance();
	    memberDAO.insertMember(memberVO);
	    
	    session.setAttribute("id",request.getParameter("id"));
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
