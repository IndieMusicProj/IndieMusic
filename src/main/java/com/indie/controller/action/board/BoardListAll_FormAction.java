package com.indie.controller.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dto.BoardVO;
import com.indie.dto.PageVO;

public class BoardListAll_FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BoardList_All_form 실행");
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		String url = "board/boardList.jsp";
		
		int page = 1;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageVO paging = new PageVO();
		
		int count = boardDAO.getAllCount();
		
		paging.setPage(page);	// 현재 페이지
		paging.setTotalCount(count);	// 전체 레코드의 갯수
		
		List<BoardVO> boardList = boardDAO.getBoardListByNewestPaging(paging);
		String title_category = request.getParameter("b_category");
		
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("title_category", title_category);
		request.setAttribute("paging", paging);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
