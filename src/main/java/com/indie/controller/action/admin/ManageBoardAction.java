package com.indie.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dto.BoardVO;

public class ManageBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시판 관리 컨트롤러 실행");
		String url = "/adminMode/board/manageBoard.jsp";
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		ArrayList<BoardVO> boardInfoList = (ArrayList<BoardVO>) boardDAO.getBoardListByNewest();
		
		request.setAttribute("selected", "board");
		request.setAttribute("boardInfoList", boardInfoList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
