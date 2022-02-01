

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.management.RuntimeErrorException;



public class EnvoyerMail {
	
	private String username = "phpmailerdugny@gmail.com";
	private String password = "Mailer1234";
	public void envoyer() {
		//Creation de session
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		System.out.println(session);
		try {
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("phpmailerdugny@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jeremie.lelong77@gmail.com"));
			message.setSubject("Test javaMail API");
			message.setText("Test");
			
			Transport.send(message);
			System.out.println("Message envoyé");
			
			
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
			
		
		
	}
	public static void main(String[] args) {
		EnvoyerMail envoyerMail = new EnvoyerMail();
		envoyerMail.envoyer();

	}

}
