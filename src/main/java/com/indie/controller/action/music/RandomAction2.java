package com.indie.controller.action.music;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;

public class RandomAction2 implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		String url = "music/randomAction.jsp";
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		int count = Integer.parseInt(request.getParameter("r_num"));
		int[] random = new int[count];
		
		MusicDAO musicDAO = MusicDAO.getInstance();
		musicDAO.updateCnt(id);
		ArrayList<MusicVO> list = new ArrayList<MusicVO>();
		MusicVO musicVO = new MusicVO();
		
		
		for(int i=0; i<count; i++) {
			random[i] = (int)(Math.random()*80)+1;
			
			for(int j=0; j<i; j++) {
				if(random[i] == random[j]) {
					i--;
					break;
				}
			}
//			System.out.println(random[i]+ " ");
		}
		for(int num : random) {
			System.out.println(num);
			musicVO = musicDAO.getRandom(num); 
			list.add(musicVO);
		}
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
