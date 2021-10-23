package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dto.AdminVO;
import com.indie.dto.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ManageBoardInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시판 등록 컨트롤러 실행");
		String url = "/IndieServlet?command=manage_board";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		BoardVO boardVO = new BoardVO();

		HttpSession session = request.getSession();
		AdminVO loginAdmin = (AdminVO) session.getAttribute("loginAdmin");
		
		String savePath = "img/board";
		int uploadFileSizeLimit = 5 * 1024 *1024;
		String encType = "UTF-8";
		
		ServletContext context = request.getSession().getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("파일이 저장된 주소 : "+ uploadFilePath);
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request,
					uploadFilePath,
					uploadFileSizeLimit,
					encType,
					new DefaultFileRenamePolicy());
			
			// 서버 파일 이름 : 서버 파일 이름으로 db 저장 하도록 사용
//			multi.getFilesystemName("b_picture");
			// 실제 파일이름
//			multi.getOriginalFileName("b_picture");
			
			boardVO.setAdm_num(loginAdmin.getAdm_num());
			boardVO.setB_category(multi.getParameter("b_category"));
			boardVO.setB_title(multi.getParameter("b_title"));
			boardVO.setB_content(multi.getParameter("b_content"));
			String pic = multi.getFilesystemName("b_picture")!=""?multi.getFilesystemName("b_picture"):"noimg.png";
			boardVO.setB_picture(pic);
		} catch (Exception e) {
			e.printStackTrace();
		}	// catch
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.insertBoard(boardVO);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
