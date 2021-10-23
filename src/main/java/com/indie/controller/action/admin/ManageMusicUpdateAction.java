package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ManageMusicUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getContextPath() +"/IndieServlet?command=manage_music";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		MusicVO musicVO = new MusicVO();
		
		MusicDAO musicDAO = MusicDAO.getInstance();

		String savePath = "img/music";
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
//			multi.getFilesystemName("m_album_pic");
			// 실제 파일이름
//			multi.getOriginalFileName("m_album_pic");
			
			musicVO.setM_id(Integer.parseInt(multi.getParameter("m_id")));
			musicVO.setM_name(multi.getParameter("m_name"));
			musicVO.setM_artist(multi.getParameter("m_artist"));
			musicVO.setM_nation(multi.getParameter("m_nation"));
			musicVO.setM_album(multi.getParameter("m_album"));
			musicVO.setM_album_pic(multi.getFilesystemName("m_album_pic")!=null?multi.getFilesystemName("m_album_pic"):"noimg.png");
			musicVO.setM_genre(multi.getParameter("m_genre"));
			musicVO.setM_lyrics(multi.getParameter("m_lyrics")!=null?multi.getParameter("m_lyrics"):"가사 없음");
		} catch (Exception e) {
			e.printStackTrace();
		}	// catch
		
		musicDAO.updateMusic(musicVO);
		
		response.sendRedirect(url);
	}

}
