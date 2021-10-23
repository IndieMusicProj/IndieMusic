package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dto.BoardVO;

public class ManageBoardDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시판 상세 컨트롤러 실행");
		String url = "/adminMode/board/detailBoardForm.jsp";

		String b_num = request.getParameter("b_num");

		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardVO boardInfo = boardDAO.getBoard(Integer.parseInt(b_num));

		request.setAttribute("selected", "board");
		request.setAttribute("boardInfo", boardInfo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
