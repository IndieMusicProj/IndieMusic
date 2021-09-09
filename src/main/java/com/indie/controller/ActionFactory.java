package com.indie.controller;

import com.indie.controller.action.Action;
import com.indie.controller.action.IndexAction;
import com.indie.controller.action.admin.AdminIndexAction;
import com.indie.controller.action.admin.AdminLoginAction;
import com.indie.controller.action.admin.AdminLoginFormAction;
import com.indie.controller.action.admin.InsertAdminFormAction;
import com.indie.controller.action.admin.InsertMusicAction;
import com.indie.controller.action.admin.InsertMusicFormAction;
import com.indie.controller.action.member.JoinAction;
import com.indie.controller.action.member.LoginAction;
import com.indie.controller.action.music.AllNewMusicAction;
import com.indie.controller.action.music.AllPopMusicAction;
import com.indie.controller.action.music.ForBalladMusicAction;
import com.indie.controller.action.music.ForDanceMusicAction;
import com.indie.controller.action.music.ForHiphopMusicAction;
import com.indie.controller.action.music.ForIndieMusicAction;
import com.indie.controller.action.music.ForNewMusicAction;
import com.indie.controller.action.music.ForPopMusicAction;
import com.indie.controller.action.music.KorBalladMusicAction;
import com.indie.controller.action.music.KorDanceMusicAction;
import com.indie.controller.action.music.KorHiphopMusicAction;
import com.indie.controller.action.music.KorIndieMusicAction;
import com.indie.controller.action.music.KorNewMusicAction;
import com.indie.controller.action.music.KorPopMusicAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory(); 
	
	private ActionFactory() {
		
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory에 요청 사항 : "+ command);
		
		if(command.equals("index")) {
			action = new IndexAction();
		}
		// admin part
		else if(command.equals("admin_login_form")) {
			action = new AdminLoginFormAction();
		} else if(command.equals("admin_login")) {
			action = new AdminLoginAction();
		} else if(command.equals("admin_index")) {
			action = new AdminIndexAction();
		} else if(command.equals("insert_music_form")) {
			action = new InsertMusicFormAction();
		} else if(command.equals("insert_admin_form")) {
			action = new InsertAdminFormAction();
		}
		// music part
		else if(command.equals("AllPopular")) {
			action = new AllPopMusicAction();
		}else if(command.equals("KorPopular")) {
			action = new KorPopMusicAction();
		}else if(command.equals("ForPopular")) {
			action = new ForPopMusicAction();
		}else if(command.equals("AllNewest")) {
			action = new AllNewMusicAction();
		}else if(command.equals("KorNewest")) {
			action = new KorNewMusicAction();
		}else if(command.equals("ForNewest")) {
			action = new ForNewMusicAction();
		}else if(command.equals("KorBallad")) {
			action = new KorBalladMusicAction();
		}else if(command.equals("KorDance")) {
			action = new KorDanceMusicAction();
		}else if(command.equals("KorHiphop")) {
			action = new KorHiphopMusicAction();
		}else if(command.equals("KorIndie")) {
			action = new KorIndieMusicAction();
		}else if(command.equals("ForBallad")) {
			action = new ForBalladMusicAction();
		}else if(command.equals("ForDance")) {
			action = new ForDanceMusicAction();
		}else if(command.equals("ForHiphop")) {
			action = new ForHiphopMusicAction();
		}else if(command.equals("ForIndie")) {
			action = new ForIndieMusicAction();
		}
		// join part
		else if(command.equals("login")) {
			action = new LoginAction();
		}else if(command.equals("join")) {
			action = new JoinAction();
		}
		// board part
		
		
		
		
		return action;
	}
}
