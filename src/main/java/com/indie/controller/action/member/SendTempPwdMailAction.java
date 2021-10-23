package com.indie.controller.action.member;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

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

public class SendTempPwdMailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/member/findPwdResultFail.jsp";
		
		String mb_id = request.getParameter("id");
		String mb_email = request.getParameter("email");

		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberVO = memberDAO.checkMemberByEmail(mb_email);

		if(mb_id.equals(memberVO.getMb_id())) {
			System.out.println("비밀번호 찾기용 회원정보 수집 성공");

			// 임시 비밀번호 발급
			// UUID를 이용한 방식으로 자바 1.5 버전 이상부터 지원함.

			// UUID(Universally unique identifier)
			// UUID 는 다른 말로 '범용 고유 번호' 라고 불리며
			// 다음과 같이 숫자와 영문자 128비트 코드로 구성되어 있다.
			// EX : b633095d-21e0-4338-9804-d7ae5f3311fa

			// 우리는 자바 기능을 이용하여 UUID를 뽑아내서 앞에 8자리를 사용
			// db에 저장시키고 이메일을 통해 고객이 로그인을 할 수 있도록 유도함.
			
			// 8개의 숫자와 영문자이므로 대략 2,821,109,907,456개(약 3조개)의 경우의 수가 나오고
			// 8개만 사용해도 우연히 맞출 확률은 현저히 낮음

			String tempPwd = UUID.randomUUID().toString().replaceAll("-", ""); // - 제거
			tempPwd = tempPwd.substring(0, 8); // 8자리 출력
			System.out.println("임시 비밀번호 : " + tempPwd);

			// 임시 비밀번호 db 수정
			memberDAO.updateTempPwd(mb_id, tempPwd);
			
			// 임시 비밀번호 전송
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

				msg.setSubject("[Indie Music] 임시 비밀번호 발급", "UTF-8");
				msg.setText(
						"<h1>임시 비밀번호 발급</h1><br><br>아이디가 생각나지 않을시 <a href='http://localhost:8181/IndieMusic/member/findIdForm.jsp'>아이디 찾기</a>를 이용해주세요.<br><br> 임시 비밀번호 : "
								+ tempPwd,
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

			url = "/member/findPwdResult.jsp";
		} else {
			request.getRequestDispatcher(url).forward(request, response);
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
