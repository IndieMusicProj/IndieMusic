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

public class BoardListCategory_FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BoardList_Category_form 실행");
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		PageVO paging = new PageVO();
		
		String url = "board/boardList.jsp";
		
		int page = 1;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		String category = request.getParameter("b_category");
		
		int count = boardDAO.getCategoryCount(category);
		
		paging.setPage(page);	// 현재 페이지
		paging.setTotalCount(count);	// 전체 레코드의 갯수
		
		List<BoardVO> boardList = boardDAO.getBoardListByCategoryPaging(category, paging);
		
		System.out.println(category);
//		List<BoardVO> boardList = boardDAO.getBoardListByCategory(category);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging", paging);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	// 해당 category를 찾아 read하는 방식으로 구현 (아래와 다름)
	// 넘어온 category별로 vo객체에 다르게 대입. 
	// ex) if (category.equals("News") { : getBoardListByCategory(String category) { 
	// category = ? pstmt.setString(request.getParameter(category)) //category가 news인 컬럼들을 찾아 출력하는 메소드

}
