package com.indie.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Board_Update 실행");
		String url = "board/boardList.jsp";
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		
		vo.setB_num(Integer.parseInt(request.getParameter("b_num"))); // url 통해 해당 게시글 번호 값 넘겨받음.
		vo.setB_category(request.getParameter("b_category"));
		vo.setB_title(request.getParameter("b_title"));
		vo.setB_content(request.getParameter("b_content"));
		
		boardDAO.updateBoard(vo);		
		
		response.sendRedirect(url);
	}

}
