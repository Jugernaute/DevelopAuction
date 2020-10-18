package ua.com.method.subscribers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.method.Mail;

@Component
public interface Observer {

    void handleEvent(String productName, String productModel, int currentPrice) throws InterruptedException;
}
