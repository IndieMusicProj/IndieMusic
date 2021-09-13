package com.indie.controller.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Board_Delete 실행");
		String url = "board/boardList.jsp";
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		int b_num = Integer.parseInt(request.getParameter("b_num"));  // url 통해 해당 게시글 번호 값 넘겨받음.
		boardDAO.deleteBoard(b_num);
		
		response.sendRedirect(url);
	}

}
