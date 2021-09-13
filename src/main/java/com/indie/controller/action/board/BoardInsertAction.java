package com.indie.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dto.BoardVO;

public class BoardInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Board_Insert 실행");
		String url = "board/boardList.jsp";
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		
		vo.setB_category(request.getParameter("b_category"));
		vo.setB_title(request.getParameter("b_title"));
		vo.setB_content(request.getParameter("b_content"));
		
		boardDAO.insertBoard(vo);		
		
		response.sendRedirect(url);
	}

}
