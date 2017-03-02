package com.luvao.mail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailSSL {

	public void enviarMensaje(String nombre, String email, String asunto, String mensaje)
			throws FileNotFoundException, IOException {
		String linea = System.getProperty("line.separator");
		Properties properties = new Properties();
//		InputStream in  = ClassLoader.getSystemResourceAsStream("/WebSiteLuvao/src/resources/MailSSL.properties");
		
		InputStream in  = this.getClass().getResourceAsStream("MailSSL.properties");
		properties.load(in);
		in.close();
		
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(properties.getProperty("admin"), properties.getProperty("password"));
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(properties.getProperty("admin")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(properties.getProperty("receptor")));
			message.setSubject(asunto);
			message.setText("El Señor :  " + nombre + linea + "correo : " + email + linea + "mesaje : " + mensaje);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
