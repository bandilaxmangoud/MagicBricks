package com.MagicBricks.utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.VerticalAlignment;
import org.jfree.util.Rotation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.awt.Color;
import java.awt.Font;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ConfiguratorSupport;
import com.ctaf.support.ReportStampSupport;


public class BarchartUtil {
	
	static ConfiguratorSupport cf = new ConfiguratorSupport("config.properties");
	
	public static void generateEmailReport() throws Exception {

		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("    <head>");
		sb.append("    </head>");
		sb.append("    <body style=\"font-family: Tahoma, Verdana, Segoe, sans-serif;;font-size: 14px\">");
		sb.append("        <h2 align=\"center\" style=\"color: #003399\">SummerLand Automation Results Summary</h2>");
		sb.append("        <table border=\"1\" width=\"45%\" style=\"border-collapse:collapse; border: solid 1px #ffffff\"  align=\"center\">");
		sb.append("            <tbody>");
		sb.append("                <tr bgcolor=\"#B9C9FE\">");
		sb.append("                    <td colspan=\"2\" style=\"border:solid 1px #ffffff;text-align: center;height: 25px;color:#003399\"><strong>Environment Details</strong></td>");
		sb.append("                </tr>");

		sb.append("                <tr bgcolor=\"#E8EDFF\">");
		sb.append("                    <td style=\"border:solid 1px #ffffff;height: 25px;padding-left:10px;color:#666699\"><strong>BuildVersion</strong></td>");
		sb.append("                    <td style=\"border:solid 1px #ffffff;padding-left:10px;color:#666699\">"
				+ cf.getProperty("BuildVersion") + "</td>");
		sb.append("                </tr>");

		sb.append("                <tr bgcolor=\"#E8EDFF\">");
		sb.append("                    <td style=\"border:solid 1px #ffffff;height: 25px;padding-left:10px;color:#666699\"><Strong>Run ID</strong></td>");
		sb.append("                    <td style=\"border:solid 1px #ffffff;padding-left:10px;color:#666699\">"
				+ cf.getProperty("RunID") + "</td>");
		sb.append("                </tr>");
		sb.append("                <tr bgcolor=\"#E8EDFF\">");
		sb.append("                    <td style=\"border:solid 1px #ffffff;height: 25px;padding-left:10px;color:#666699\"><strong>Browser</strong></td>");
		sb.append("                    <td style=\"border:solid 1px #ffffff;padding-left:10px;color:#666699\">"
				+ cf.getProperty("browserType") + "</td>");
		sb.append("                </tr>");
		sb.append("                <tr bgcolor=\"#E8EDFF\">");
		sb.append("                    <td style=\"border:solid 1px #ffffff;height: 25px;padding-left:10px;color:#666699\"><strong>Language</strong></td>");
		sb.append("                    <td style=\"border:solid 1px #ffffff;padding-left:10px;color:#666699\">"
				+ cf.getProperty("language") + "</td>");
		sb.append("                </tr>");
		sb.append("                <tr bgcolor=\"#E8EDFF\">");
		sb.append("                    <td style=\"border:solid 1px #ffffff;height: 25px;padding-left:10px;color:#666699\"><strong>URL</strong></td>");
		sb.append("                    <td style=\"border:solid 1px #ffffff;padding-left:10px;color:#666699\">"
				+ cf.getProperty("URL") + "</td>");
		sb.append("                </tr>");
		sb.append("                <tr bgcolor=\"#E8EDFF\">");
		sb.append("                    <td style=\"border:solid 1px #ffffff;height: 25px;padding-left:10px;color:#666699\"><Strong>Test Date</strong></td>");
		sb.append("                    <td style=\"border:solid 1px #ffffff;padding-left:10px;color:#666699\">"
				+ ReportStampSupport.dateTime() + "</td>");
		sb.append("                </tr>");
		sb.append("            </tbody>");
		sb.append("        </table>");

		//System.out.println("passed" + TestEngine.passCounter);
		//System.out.println("failed" + TestEngine.failCounter);
		String tFailed = String.valueOf(TestEngine.failCounter);

		String tPassed = String.valueOf(TestEngine.passCounter);

		int tTotal = Integer.parseInt(tPassed) + Integer.parseInt(tFailed);

		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("Passed [" + tPassed + "]", Integer.parseInt(tPassed));
		data.setValue("Failed [" + tFailed + "]", Integer.parseInt(tFailed));

		JFreeChart chart = ChartFactory.createPieChart3D(
				"SummerLand Automation Overview", data, true, true, false);
		chart.addSubtitle(new TextTitle("Total : " + tTotal, new Font(
				"SansSerif", Font.BOLD, 12), new Color(0, 51, 153),
				RectangleEdge.BOTTOM, HorizontalAlignment.CENTER,
				VerticalAlignment.BOTTOM, RectangleInsets.ZERO_INSETS));
		chart.setBorderVisible(false);
		chart.setBackgroundPaint(Color.WHITE);
		chart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 18));
		chart.getTitle().setPaint(new Color(0, 51, 153));
		chart.getLegend().setItemPaint(new Color(0, 51, 153));
		chart.getLegend().setItemFont(new Font("SansSerif", Font.BOLD, 12));
		chart.getLegend().setBorder(0, 0, 0, 0);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(270);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		plot.setBackgroundPaint(Color.WHITE);
		plot.setOutlineVisible(false);
		plot.setLabelGenerator(null);
		plot.setSectionPaint("Passed [" + tPassed + "]", Color.GREEN);
		plot.setSectionPaint("Failed [" + tFailed + "]", Color.RED);
		// plot.setSectionPaint("Skipped [" + tSkipped + "]", Color.YELLOW);

		File ConsolidatedchartFile = File.createTempFile("chart", ".png");
		ChartUtilities.saveChartAsPNG(ConsolidatedchartFile, chart, 350, 200);

		sb.append("</br>");
		sb.append("<div align=\"center\"><img src=\"cid:consolidatedChart\" /></div>");
		sb.append("</br>");
		sb.append("<div>");
		sb.append("    <table border=\"0\" cellspacing=\"5\" align=\"center\">");
		sb.append("        <tbody>");
		sb.append("             <tr>");

		Map<String, File> chartMap = new HashMap<String, File>();

		String lPassed = tPassed;
		String lFailed = tFailed;
		// String lSkipped = tSkipped;
		String lProject = "SummerLand";
		tTotal = Integer.parseInt(lPassed) + Integer.parseInt(lFailed);

		data = new DefaultPieDataset();
		data.setValue("Passed [" + lPassed + "]", Integer.parseInt(lPassed));
		data.setValue("Failed [" + lFailed + "]", Integer.parseInt(lFailed));

		chart = ChartFactory.createPieChart3D(lProject
				+ "SummerLand Automation Overview", data, true, true, false);
		chart.addSubtitle(new TextTitle("Total : " + tTotal, new Font(
				"SansSerif", Font.BOLD, 12), new Color(0, 51, 153),
				RectangleEdge.BOTTOM, HorizontalAlignment.CENTER,
				VerticalAlignment.BOTTOM, RectangleInsets.ZERO_INSETS));
		chart.setBorderVisible(false);
		chart.setBackgroundPaint(Color.WHITE);
		chart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 18));
		chart.getTitle().setPaint(new Color(0, 51, 153));
		chart.getLegend().setItemPaint(new Color(0, 51, 153));
		chart.getLegend().setItemFont(new Font("SansSerif", Font.BOLD, 12));
		chart.getLegend().setBorder(0, 0, 0, 0);

		plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(270);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		plot.setBackgroundPaint(Color.WHITE);
		plot.setOutlineVisible(false);
		plot.setLabelGenerator(null);

		plot.setSectionPaint("Passed [" + lPassed + "]", Color.GREEN);
		plot.setSectionPaint("Failed [" + lFailed + "]", Color.RED);

		File tFile = File.createTempFile("chart", ".png");
		ChartUtilities.saveChartAsPNG(tFile, chart, 300, 200);

		// sb.append("                <td><img src=\"cid:" + lProject +
		// "Chart\" /></td>");

		chartMap.put(lProject + "Chart", tFile);

		sb.append("            </tr>");
		sb.append("        </tbody>");
		sb.append("    </table>");
		sb.append("</div>");
		// sb.append("</br><div style=\"color:#003399\"><div style=\"text-align:center\">Platform url : "+con+"</div>");
		// sb.append("</br><div style=\"text-align:center\"><a href=\"http://chrjo08-w71:8080/ITSMQAAnalytics/\">Click here</a> to view the dashboard.</div>");
		sb.append("</br><div style=\"text-align:center\">*All Results and screenshots are attached in zip file</div></div>");
		sb.append("</br><div style=\"text-align:center\">*Failure test cases need to checked manually.</div></div>");
		sb.append("</br></br><div style=\"color:#666699\"><div>Thanks & Regards,</div>");
		sb.append("<div>Veera Reddy</div></div>");
		sb.append("    </body>");
		sb.append("</html>");
		String emailBody = sb.toString();

		String host = "smtp.gmail.com";
		String subject = "SummerLand Automation Results";

		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(cf
								.getProperty("UserName"), cf
								.getProperty("Password"));// change
																// accordingly
					}
				});
		
		
		
		Message message = new MimeMessage(session);
		
		
		message.setFrom(new InternetAddress(cf.getProperty("UserName")));
		if (cf.getProperty("To").contains(";")) {

			for (int i = 0; i < cf.getProperty("To").split(";").length; i++)
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(cf.getProperty("To")
								.split(";")[i]));
		} else
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					cf.getProperty("To")));

		if (cf.getProperty("CC").contains(";")) {

			for (int i = 0; i < cf.getProperty("CC").split(";").length; i++)
				message.addRecipient(Message.RecipientType.CC,
						new InternetAddress(cf.getProperty("CC")
								.split(";")[i]));
		} else
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(
					cf.getProperty("CC")));

		message.setSubject(subject);

		MimeMultipart multipart = new MimeMultipart("mixed");
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(emailBody,"text/html"); 
		multipart.addBodyPart(messageBodyPart);

		messageBodyPart = new MimeBodyPart();
		DataSource fds = new FileDataSource(ConsolidatedchartFile);
		messageBodyPart.setDataHandler(new DataHandler(fds));
		messageBodyPart.setHeader("Content-ID", "<consolidatedChart>");
		multipart.addBodyPart(messageBodyPart);

		// This affecting ATT0000xx.bin creation.......
		/*for (Map.Entry<String, File> entry : chartMap.entrySet()) {
			messageBodyPart = new MimeBodyPart();
			fds = new FileDataSource(entry.getValue());
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<" + entry.getKey() + ">");
			multipart.addBodyPart(messageBodyPart);
		}*/

		File folder = new File("Results/Chrome");
		File[] listOfFiles = folder.listFiles();

		String filename = "Automation Results.zip";

		zipFolder(
				"Results/Chrome" + "/"
						+ listOfFiles[listOfFiles.length - 1].getName(),
				filename);

		messageBodyPart = new MimeBodyPart();

		DataSource source = new FileDataSource(filename);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);

		multipart.addBodyPart(messageBodyPart);

		/*File log = new File("Logs");
		File[] logfiles = log.listFiles();
		String logfile = "Logs" + File.separator + logfiles[0].getName();
		messageBodyPart = new MimeBodyPart();
		DataSource source1 = new FileDataSource(logfile);
		messageBodyPart.setDataHandler(new DataHandler(source1));
		messageBodyPart.setFileName(logfile);

		multipart.addBodyPart(messageBodyPart);*/
		message.setContent(multipart);
		Transport.send(message);

		System.out.println("Sent mail successfully.");

	}
	
	static public void zipFolder(String srcFolder, String destZipFile)
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
				if (!fileName.contains("TestScenarios"))
					addFileToZip(folder.getName(), srcFolder + "/" + fileName,
							zip);
			} else {
				addFileToZip(path + "/" + folder.getName(), srcFolder + "/"
						+ fileName, zip);
			}
		}

	}
public static void main(String a[]) throws Exception{
		
	generateEmailReport();
	
	}

}
