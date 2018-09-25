//package ua.com.method;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//@Component
//public class Mail {
//
//    @Autowired
//    public JavaMailSender sender;
//
//    public void sendMail(String email, String subject, String text){
//        MimeMessage mimeMessage = sender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
//        try {
//            helper.setText(text, true);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        try {
//            helper.setSubject(subject);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        try {
//            helper.setTo(email);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        sender.send(mimeMessage);
//    }
//
//
//}
