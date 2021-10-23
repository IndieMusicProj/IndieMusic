package com.indie.controller.action.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.AddressDAO;
import com.indie.dto.AddressVO;

public class FindZipNumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/findZipNum.jsp";
		
		String dong = request.getParameter("dong");
		
		if(dong != null && dong.trim().equals("") == false) {
			AddressDAO addressDAO = AddressDAO.getInstance();
			List<AddressVO> addressList = addressDAO.selectAddressByDong(dong.trim());
			request.setAttribute("addressList", addressList);
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
