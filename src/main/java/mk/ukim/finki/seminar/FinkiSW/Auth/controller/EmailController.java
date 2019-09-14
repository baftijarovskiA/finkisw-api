package mk.ukim.finki.seminar.FinkiSW.Auth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {

    @RequestMapping(value = "/sendemail")
    public String sendEmail(String account, String username, String password, int removed) throws MessagingException {
        sendmail(account,username,password,removed);
        return "Email sent successfully";
    }

    private void sendmail(String email, String username, String password, int removed) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("noreply.seminar.finki@gmail.com", "FinkiSeminar1");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("noreply.seminar.finki@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

        if(removed == 1){
            msg.setSubject("Account removed");
            msg.setContent("We are sorry, but your account with this email address and username: " +
                    "<b>"+username+"</b> was removed from our database.<br/>", "text/html");
        } else{
            if(removed == 0)
                msg.setSubject("Registration Confirmed");
            else if(removed == 2)
                msg.setSubject("Password changed!");

            msg.setContent("Here are your credentials: <br>" +
                    "Username: <b>"+username+"</b> <br/>" +
                    "Password: <i><b>"+password+"</b></i> <br/>" +
                    "Make sure you save the password for security reasons!", "text/html");
        }

        msg.setSentDate(new Date());
        Transport.send(msg);
    }
}
