package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.entity.User;
import ua.com.method.Mail;
import ua.com.method.RandomStr;
import ua.com.service.UserService;

@RestController
public class MyRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private Mail mail;

    @PostMapping("/sendKeys")
    public void userSave(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        String s = RandomStr.randomKey();
        User user = userService.findByUsername(name);
        user.setRandomKey(s);
        String email = user.getEmail();
        String subjectForgotPassword = "Підтвердження дій для зміни пароля";
        String text = "Your key for change password: "+ s;
        mail.sendMail(email,subjectForgotPassword,text);

    }

}
