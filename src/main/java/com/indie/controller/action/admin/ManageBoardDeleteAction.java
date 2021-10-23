package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;

public class ManageBoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시판 삭제 컨트롤러 실행");
		String url = request.getContextPath()+"/IndieServlet?command=manage_board";

		String b_num = request.getParameter("b_num");

		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.deleteBoard(Integer.parseInt(b_num));

		response.sendRedirect(url);
	}

}
