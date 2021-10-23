package com.indie.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;
import com.indie.dto.MemberVO;

public class KakaoAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberVO = memberDAO.getMember(id);

		if(memberVO == null){
			MemberVO member = new MemberVO();
			member.setMb_id(id);
			member.setMb_name(name);
			member.setMb_email(email);
		    
			System.out.printf(id,name,email);
		    memberDAO.insertKakao(member);
		    
		    session.setAttribute("loginUser", memberVO);
		    url ="IndieServlet?command=index";
		}else if(memberVO != null){
			if (memberVO.getMb_email().equals(email)) {
				session.removeAttribute("id");
				session.setAttribute("loginUser", memberVO);
				url = request.getContextPath() + "/IndieServlet?command=index";
				System.out.println(url);
			}
		}
		
		response.sendRedirect(url);
	}

}
