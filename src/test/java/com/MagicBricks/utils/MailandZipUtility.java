package com.MagicBricks.utils; 



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.ctaf.support.ConfiguratorSupport;

public class MailandZipUtility {

	public static ConfiguratorSupport configProps = new ConfiguratorSupport(
			"config.properties");

	public static  void sendNotification() throws Exception {

		// Recipient's email ID needs to be mentioned.
		String[] toMailerList = configProps.getProperty("To").split(",");
		System.out.println(configProps.getProperty("To"));
		String[] ccMailerList = configProps.getProperty("CC").split(",");
		System.out.println(configProps.getProperty("CC"));
		final String username = configProps.getProperty("UserName");
		final String password = configProps.getProperty("Password");
		String from = configProps.getProperty("From");

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			
			javax.mail.internet.InternetAddress[] addressTo = new javax.mail.internet.InternetAddress[toMailerList.length];

			for (int i = 0; i < toMailerList.length; i++) {
				addressTo[i] = new javax.mail.internet.InternetAddress(
						toMailerList[i]);
			}
			message.setRecipients(javax.mail.Message.RecipientType.TO,
					addressTo);
			
			javax.mail.internet.InternetAddress[] addressCC = new javax.mail.internet.InternetAddress[ccMailerList.length];
			for (int i = 0; i < ccMailerList.length; i++) {
				addressCC[i] = new javax.mail.internet.InternetAddress(
						ccMailerList[i]);
			}
			message.setRecipients(javax.mail.Message.RecipientType.CC,
					addressCC);
			// Set Subject: header field
			message.setSubject("SummerLand Automation Results");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart
					.setContent(
									"Hi, <br><br>"
									+configProps.getProperty("body")
									
								
									+ "<br><br>Thanks,<br>Veera Reddy<br><br>",
							"text/html; charset=utf-8");
			String filename = "SummerLand Selenium Automation Reports.zip";
			zipDir(configProps.getProperty("srcFolder"), filename);
			// Create a multipart message
			Multipart multipart = new MimeMultipart();
			// Set text message part
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			BodyPart messageBodyPart1 = new MimeBodyPart();
		    messageBodyPart1 = new MimeBodyPart();
           
            DataSource source = new FileDataSource(filename);
            messageBodyPart1.setDataHandler(new DataHandler(source));
            messageBodyPart1.setFileName(filename);
         
            multipart.addBodyPart(messageBodyPart1);
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	

		static public void zipDir(String srcFolder, String destZipFile)
				throws Exception {
			ZipOutputStream zip = null;
			FileOutputStream fileWriter = null;

			fileWriter = new FileOutputStream(destZipFile);
			zip = new ZipOutputStream(fileWriter);

			addFolderToZip("", srcFolder, zip);
			zip.flush();
			zip.close();
		}

		static private void addFileToZip(String path, String srcFile,
				ZipOutputStream zip) throws Exception {

			File folder = new File(srcFile);
			if (folder.isDirectory()) {
				addFolderToZip(path, srcFile, zip);
			} else {
				byte[] buf = new byte[1024];
				int len;
				@SuppressWarnings("resource")
				FileInputStream in = new FileInputStream(srcFile);
				zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
				while ((len = in.read(buf)) > 0) {
					zip.write(buf, 0, len);
				}
			}
		}

		static private void addFolderToZip(String path, String srcFolder,
				ZipOutputStream zip) throws Exception {
			File folder = new File(srcFolder);

			for (String fileName : folder.list()) {
				if (path.equals("")) {
					addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
				} else {
					addFileToZip(path + "/" + folder.getName(), srcFolder + "/"
							+ fileName, zip);
				}
			}
		}
	
	public static void main(String a[]) throws Exception{
		
		sendNotification();
	}

}