package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTest {
    public static void main(String[] args) throws Exception {
    	Properties p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.naver.com");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.port", "587");
 
//        Authenticator auth = new MyAuthentication();
//        Session session = Session.getDefaultInstance(p, auth);
        Session session = Session.getInstance(p,
        		   new javax.mail.Authenticator(){
        		    protected PasswordAuthentication getPasswordAuthentication(){
        		     return new PasswordAuthentication("v_donguk@naver.com","anqmdnr31#%") ;
        		    }
        		   });

        MimeMessage msg = new MimeMessage(session);
 
        try {
            msg.setSentDate(new Date());
            InternetAddress from = new InternetAddress();
            
            from = new InternetAddress("v_donguk<v_donguk@naver.com>");
            msg.setFrom(from);
 
            InternetAddress to = new InternetAddress("geolee20@gmail.com");
            msg.setRecipient(Message.RecipientType.TO, to);
 
            msg.setSubject("title", "UTF-8");
            msg.setText("content", "UTF-8");
            msg.setHeader("content-Type", "text/html");
 
            javax.mail.Transport.send(msg);
        } catch (AddressException addr_e){
            addr_e.printStackTrace();
        } catch (MessagingException msg_e){
            msg_e.printStackTrace();
        } finally {
			System.out.println("이메일 정상 발송");
		}
    }
}

class MyAuthentication extends Authenticator {
 
    PasswordAuthentication account;
 
    public MyAuthentication(){
        String id = "v_donguk";
        String pw = "anqmdnr31#%";
        account = new PasswordAuthentication(id, pw);
    }
 
    public PasswordAuthentication getPasswordAuthentication(){
        return account;
    }
}

/*
 * String host = "smtp.naver.com"; final String username = "v_donguk"; final
 * String password = "anqmdnr31#%"; // 네이버 이메일 비밀번호를 입력해주세요. int port = 465; //
 * 포트번호
 * 
 * // 메일 내용 String recipient = memberVO.getMb_email(); // 받는 사람의 메일주소를 입력해주세요.
 * String subject = "메일테스트"; // 메일 제목 입력해주세요. String body = username +
 * "님으로 부터 메일을 받았습니다."; // 메일 내용 입력해주세요. Properties props =
 * System.getProperties(); // 정보를 담기 위한 객체 생성
 * 
 * // SMTP 서버 정보 설정 props.put("mail.smtp.host", host);
 * props.put("mail.smtp.port", port); props.put("mail.smtp.auth", "true");
 * props.put("mail.smtp.ssl.enable", "true"); props.put("mail.smtp.ssl.trust",
 * host);
 * 
 * // Session 생성 Session session = Session.getDefaultInstance(props, new
 * javax.mail.Authenticator() { String un = username; String pw = password;
 * 
 * protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
 * return new javax.mail.PasswordAuthentication(un, pw); } });
 * session.setDebug(true); // for debug
 * 
 * Message mimeMessage = new MimeMessage(session); // MimeMessage 생성
 * 
 * try { // 발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
 * mimeMessage.setFrom(new InternetAddress("indiemusic@indie.com"));
 * 
 * // 수신자셋팅 // .TO 외에 .CC(참조) .BCC(숨은참조) 도 있음
 * mimeMessage.setRecipient(Message.RecipientType.TO, new
 * InternetAddress(recipient));
 * 
 * mimeMessage.setSubject(subject); // 제목셋팅 mimeMessage.setText(body); // 내용셋팅
 * Transport.send(mimeMessage); // javax.mail.Transport.send() 이용
 * 
 * } catch (Exception e) { System.out.println("이메일 발송 오류"); e.printStackTrace();
 * }
 */
