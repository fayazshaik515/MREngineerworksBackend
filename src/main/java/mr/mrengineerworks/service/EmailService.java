package mr.mrengineerworks.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String userEmail, String subject, String body) {
        MimeMessage message = mailSender.createMimeMessage();
        try {

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("princefayaz034@gmail.com"); 
            helper.setTo("princefayaz034@gmail.com"); 
            helper.setSubject(subject);
            helper.setText(body, true);             
            InternetAddress replyToAddress = new InternetAddress(userEmail);
            message.setReplyTo(new InternetAddress[]{replyToAddress}); 

            mailSender.send(message);
        } catch (Exception e) { 
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}
