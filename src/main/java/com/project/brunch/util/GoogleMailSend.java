package com.project.brunch.util;

import java.util.Date;
import java.util.Properties;
 
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.project.brunch.service.admin.AdminUserService;

public class GoogleMailSend {
	
	public void sendMail(String mail) {
		System.out.println("GoogleMailSendTest : " + mail);
		// 메일 인코딩
		final String bodyEncoding = "UTF-8"; // 콘텐츠 인코딩
		
		String subject = "Brunch 관리자";
		String fromEmail = "admin@brunch.co.kr"; // 보낼 이메일 주소 
		String fromUsername = "ADMIN";
		String toEmail = mail; // 받을 이메일주소
		
		final String username = "aryeong0325@gmail.com"; // google 계정
		final String password = "ojyufezwgrrpnmat"; // 발급받은 앱 비밀번호
		
		// 메일에 출력할 텍스트 
		StringBuffer sb = new StringBuffer();
		sb.append("<h3>안녕하세요 Brunch입니다.</h3>");
		sb.append("<h4>회원님께서는 Brunch 규정을 위반하셨기 때문에 아이디가 정지되었습니다.</h4>");
		String html = sb.toString();
		
		// 메일 옵션 설정
		Properties props = new Properties();    
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "465");
	    props.put("mail.smtp.auth", "true");
	 
	    props.put("mail.smtp.quitwait", "false");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.socketFactory.fallback", "false");
	    
	    try {
			// 메일 서버 인증 계정 설정
	    	Authenticator auth = new Authenticator() {
	    		protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			};
			
			// 메일 세션 생성
			Session session = Session.getInstance(props, auth);
			
			// 메일 송/수신 옵션 설정
		      Message message = new MimeMessage(session);
		      message.setFrom(new InternetAddress(fromEmail, fromUsername));
		      message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail, false));
		      message.setSubject(subject);
		      message.setSentDate(new Date());
		      
		      // 메일 콘텐츠 설정
		      Multipart mParts = new MimeMultipart();
		      MimeBodyPart mTextPart = new MimeBodyPart();
		      MimeBodyPart mFilePart = null;
		 
		      // 메일 콘텐츠 - 내용
		      mTextPart.setText(html, bodyEncoding, "html");
		      mParts.addBodyPart(mTextPart);
		            
		      // 메일 콘텐츠 설정
		      message.setContent(mParts);
		      
		      // MIME 타입 설정
		      MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
		      MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		      MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		      MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		      MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		      MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		      CommandMap.setDefaultCommandMap(MailcapCmdMap);
		 
		      // 메일 발송
		      Transport.send( message );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
