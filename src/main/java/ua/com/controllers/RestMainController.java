package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ua.com.editor.UserEditor;
import ua.com.editor.UserValidator;
import ua.com.entity.User;
import ua.com.method.Mail;
import ua.com.method.RandomStr;
import ua.com.service.user.UserService;

import java.util.List;


@RestController
@PropertySource("classpath:validation.properties")
public class RestMainController {
    @Autowired
    private Mail mail;
    @Autowired
    private UserService userService;
    @Autowired
    private Environment environment;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserEditor userEditor;
    @Autowired
    private PasswordEncoder passwordEncoder;


//    @PutMapping("sendKeys_lostPsw")
//    private void sendkeysLostPsw(@RequestBody String email){
//        User userByEmail = userService.findByEmail(email);
//        if(userByEmail==null){
//            return;
//        }
//        String s = RandomStr.randomKey();
//        userByEmail.setRandomKey(s);
//        String subjectForgotPassword = "Підтвердження дій для зміни пароля";
//        String text = "Your key for change password: "+ s;
//        mail.sendMail(email, subjectForgotPassword, text);
//    }

    @PostMapping("enterKey")
    private String lost_password_ok(
            @RequestParam String randomStr,
            @RequestParam String email){
        System.out.println(randomStr + " " + email);
        User byEmail = userService.findByEmail(email);
        String randomKey = byEmail.getRandomKey();
        if(randomKey.equals(randomStr))
        {
          return "ok";
        }
        return "no";
    }

    @PostMapping("enter-lost_Password")
    private String lost_Password(
            User user,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String repeatPassword,
            BindingResult result){
        System.out.println(password);
        System.out.println(repeatPassword);
        System.out.println(email);
        User byEmail = userService.findByEmail(email);
        String property = environment.getProperty("message_pw.length.error");

        userValidator.validate(user, result);

        if(password.equals(repeatPassword))
        {
            byEmail.setPassword(password);
            userEditor.setValue(byEmail);
            byEmail.setRandomKey("");
            userService.save(byEmail);
            return environment.getProperty("change_password_success");
        }
        else{
            return property;
        }
    }
}
