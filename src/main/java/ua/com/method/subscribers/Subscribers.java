package ua.com.method.subscribers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.com.entity.User;
import ua.com.method.Mail;
import ua.com.service.user.UserService;

import java.util.List;

@Component
public class Subscribers implements Observer{
    @Autowired
    Mail mail;

    public List<User> userlist;


    public Subscribers(List<User> userlist) {
        this.userlist = userlist;
    }

    @Override
    public void handleEvent(String productName, String productModel, int currentPrice){
        String text = "Your bet made on " + productName + " "
                + productModel + " was change, and now is "
                + currentPrice;
        String subject = "Information about the lot change";

        new Thread(() -> {
            for (User user : userlist) {
                mail.sendMail(user.getEmail(), subject, text);
            }
        }).start();

    }
}
