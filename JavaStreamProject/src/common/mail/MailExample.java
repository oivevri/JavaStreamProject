package common.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailExample {
	public static void main(String[] args) {
		
	final String user = "dleotjs2018@gmail.com";
	final String password = "dPekagkrdnjs";
	
	Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
	prop.put("mail.smtp.port", 465);
	prop.put("mail.smtp.auth", "true");
	prop.put("mail.smtp.ssl.enable", "true");
	prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	
	Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(user, password);
		}
	});
	try {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(user)); // 발신 : 나(user id)
		
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("oivevri@gmail.com")); // 수신
		
		message.setSubject("제목");
		message.setText("내용");
		
		Transport.send(message); // 전송
		System.out.println("메일이 성공적으로 보내졌습니다");
	} catch (AddressException e) {
		e.printStackTrace();
	} catch (MessagingException e) {
		e.printStackTrace();
	}
	
	}
}
