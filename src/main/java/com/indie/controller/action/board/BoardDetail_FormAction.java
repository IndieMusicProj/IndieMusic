package com.indie.controller.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dto.BoardVO;

public class BoardDetail_FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Board_Detail_form 실행");
		String url = "board/boardDetail.jsp";
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardVO boardVO = new BoardVO();
		
		int b_num = Integer.parseInt(request.getParameter("b_num"));  // url 통해 해당 게시글 번호 값 넘겨받음.
		boardDAO.setReadCountUpdate(b_num);
		boardVO = boardDAO.getBoard(b_num);
		
		request.setAttribute("boardDetail", boardVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
