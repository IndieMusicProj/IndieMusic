package com.indie.controller.action.member;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;
import com.indie.dto.MemberVO;

public class FindIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/findIdResultFail.jsp";

		String mb_email = request.getParameter("email");

		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberVO = memberDAO.checkMemberByEmail(mb_email);

		if (memberVO == null) {
			request.getRequestDispatcher(url).forward(request, response);
		}
		if (memberVO != null) {
			System.out.println("아이디 찾기용 회원정보 수집 성공");

			Properties p = System.getProperties();
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.host", "smtp.naver.com");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.port", "587");

			Session session = Session.getInstance(p, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("v_donguk@naver.com", "anqmdnr31#%");
				}
			});

			MimeMessage msg = new MimeMessage(session);

			try {
				msg.setSentDate(new Date());
				InternetAddress from = new InternetAddress();

				from = new InternetAddress("IndieMusic<v_donguk@naver.com>");
				msg.setFrom(from);

				InternetAddress to = new InternetAddress(memberVO.getMb_email());
				msg.setRecipient(Message.RecipientType.TO, to);

				msg.setSubject("[Indie Music] 아이디 찾기", "UTF-8");
				msg.setText(
						"<h1>아이디 찾기</h1><br>비밀번호가 생각나지 않을시 <a href='http://localhost:8181/IndieMusic/member/findPwdForm.jsp'>비밀번호 찾기</a>를 이용해주세요.<br><br> 아이디 : "
								+ memberVO.getMb_id(),
						"UTF-8");
				msg.setHeader("content-Type", "text/html");

				javax.mail.Transport.send(msg);
			} catch (AddressException addr_e) {
				addr_e.printStackTrace();
			} catch (MessagingException msg_e) {
				msg_e.printStackTrace();
			} finally {
				System.out.println("이메일 정상 발송");
			}

			url = "/member/findIdResult.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
