package lk.ijse.bookWormLibraryManagementSystem.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendMail {

    private static Session newSession = null;
    private static final MimeMessage mimeMessage =
            new MimeMessage(Session.getDefaultInstance(new Properties(), null));

    public static void sendMail(String[] recipientSubjectBody) throws MessagingException {
        setUpServerProperties();
        draftEmail(recipientSubjectBody);
        sendEmail();
    }

    public static void setUpServerProperties() {

        Properties properties = new Properties();
        properties.put("mail.smtp.port", "587"); // Use TLS port
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        newSession = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "bookwormlibrarynetwork@gmail.com", "rjno qiip lrki jjxn");
            }
        });
    }

    public static MimeMessage draftEmail(String[] detail) throws MessagingException {

        mimeMessage.setFrom(new InternetAddress("bookwormlibrarynetwork@gmail.com"));
        String recipients = detail[0];
        String subject = detail[1];
        String body = detail[2];

        mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(recipients)));
        mimeMessage.setSubject(subject);

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(body, "text/html");

        MimeMultipart multipart = new MimeMultipart(); //mime msg's body
        multipart.addBodyPart(bodyPart);

        mimeMessage.setContent(multipart);

        return mimeMessage;
    }

    public static void sendEmail() throws MessagingException {

        String host = "smtp.gmail.com";
        String userName = "bookwormlibrarynetwork@gmail.com";
        String password = "rjno qiip lrki jjxn"; // Replace with your actual Gmail password or App Password

        Transport transport = newSession.getTransport("smtp");
        transport.connect(host, userName, password);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email Sent Successfully !");
    }

}
