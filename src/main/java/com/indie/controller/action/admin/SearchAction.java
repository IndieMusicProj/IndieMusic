package com.indie.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.SearchDAO;
import com.indie.dto.AdminVO;
import com.indie.dto.BoardVO;
import com.indie.dto.MemberVO;
import com.indie.dto.MusicVO;
import com.indie.dto.SearchVO;

public class SearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "IndieServlet?command=index";

		String tableName = request.getParameter("tableName");
		String searchKeyword = request.getParameter("searchKeyword");
		String searchCondition = request.getParameter("searchCondition");

		SearchVO searchVO = new SearchVO();
		searchVO.setTableName(tableName);
		searchVO.setSearchKeyword(searchKeyword);
		searchVO.setSearchCondition(searchCondition);

		SearchDAO searchDAO = SearchDAO.getInstance();

		if (searchVO.getTableName().equals("member")) {
			url = "/adminMode/member/manageMember.jsp";
			ArrayList<MemberVO> memberInfoList = searchDAO.searchKeywordInMember(searchVO);

			request.setAttribute("selected", "member");
			request.setAttribute("memberInfoList", memberInfoList);

			request.getRequestDispatcher(url).forward(request, response);
		} else if (searchVO.getTableName().equals("music")) {
			url = "/adminMode/music/manageMusic.jsp";
			ArrayList<MusicVO> musicInfoList = searchDAO.searchKeywordInMusic(searchVO);

			request.setAttribute("selected", "music");
			request.setAttribute("musicInfoList", musicInfoList);
			
			request.getRequestDispatcher(url).forward(request, response);
		} else if (searchVO.getTableName().equals("board")) {
			url = "/adminMode/board/manageBoard.jsp";
			ArrayList<BoardVO> boardInfoList = searchDAO.searchKeywordInBoard(searchVO);

			request.setAttribute("selected", "board");
			request.setAttribute("boardInfoList", boardInfoList);

			request.getRequestDispatcher(url).forward(request, response);

		} else if (searchVO.getTableName().equals("admin")) {
			url = "/adminMode/admin/manageAdmin.jsp";
			ArrayList<AdminVO> adminInfoList = searchDAO.searchKeywordInAdmin(searchVO);

			request.setAttribute("selected", "admin");
			request.setAttribute("adminInfoList", adminInfoList);

			request.getRequestDispatcher(url).forward(request, response);

		}else if (searchVO.getTableName().equals("main_music")) { //메인화면 검색기능
			url = "/main_search_music.jsp";
			ArrayList<MusicVO> musicInfoList = searchDAO.searchKeywordInMusic(searchVO);
			request.setAttribute("musicInfoList", musicInfoList);
			request.setAttribute("searchKeyword", searchKeyword);
			
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
