package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;
import com.indie.dto.MemberVO;

public class ManageMemberInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원 등록 컨트롤러 실행");
		String url = "/IndieServlet?command=manage_member";
		
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
	    
		request.getRequestDispatcher(url).forward(request, response);
	}

}
