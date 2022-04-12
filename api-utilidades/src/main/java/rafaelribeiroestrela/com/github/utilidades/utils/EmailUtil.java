package rafaelribeiroestrela.com.github.utilidades.utils;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import rafaelribeiroestrela.com.github.utilidades.exceptions.ApiException;
import rafaelribeiroestrela.com.github.utilidades.models.Email;

public class EmailUtil {

	public static void sendEmail(Email email) {
		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.connectiontimeout", 10000);

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(email.getFrom(), email.getPassword());

			}

		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			Multipart multipart = new MimeMultipart();
			int cont = 0;

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(email.getFrom()));

			// Seta a lista de endereços de destino
			for (String address : email.getTo()) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
			}

			// Seta a lista de endereços para cópia
			if (email.getCc() != null && !email.getCc().isEmpty()) {

				for (String address : email.getCc()) {
					message.addRecipient(Message.RecipientType.CC, new InternetAddress(address));
				}

			}

			if (email.getSubject() != null && !email.getSubject().isEmpty()) {
				// Set Subject: header field
				message.setSubject(email.getSubject());
			}

			if (email.getText() != null && !email.getText().isEmpty()) {
				// Now set the actual message
				message.setText(email.getText());
			}

			if (email.getHtml() != null && !email.getHtml().isEmpty()) {
				// Adiciona um html como anexo
				String htmlMessage = "<html>" + email.getHtml() + "</html>";
				MimeBodyPart attachmentHtml = new MimeBodyPart();
				attachmentHtml.setContent(htmlMessage, "text/html; charset=UTF-8");
				multipart.addBodyPart(attachmentHtml);
				cont++;
			}

			if (email.getAttachments() != null && !email.getAttachments().isEmpty()) {
				// Adiciona um arquivo como anexo
				for (String path : email.getAttachments()) {
					File file = new File(path);
					MimeBodyPart attachment = new MimeBodyPart();
					attachment.setDataHandler(new DataHandler(new FileDataSource(file)));
					attachment.setFileName(file.getName());
					multipart.addBodyPart(attachment);
					cont++;
				}
			}

			if (cont > 0) {
				message.setContent(multipart);
			}

			System.out.println("sending...");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException mex) {
			throw new ApiException(mex.getMessage());
		}
	}

}
