package ua.com.controllers.controllers_cabinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ua.com.editor.UserEditor;
import ua.com.editor.UserValidator;
import ua.com.entity.User;
import ua.com.method.Mail;
import ua.com.method.RandomStr;
import ua.com.service.UserService;

import java.util.List;

@RestController
@PropertySource("classpath:validation.properties")
public class RestControllerCabinet {
    @Autowired
    private UserService userService;
    @Autowired
    private Mail mail;
    @Autowired
    private UserEditor userEditor;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private Environment environment;

    @PutMapping("/change_Email")
    public String user(@RequestBody String email,
                       Model model){
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setEmail(email);
        userService.save(user);
        model.addAttribute("user",user);
        System.out.println(user.getEmail());
        return user.getEmail();
    }

    @PostMapping("/change_Password")
    private String changePassword( User userNew,
                                   @RequestParam String password,
                                   @RequestParam String oldPassword,
                                   @RequestParam String repeatPassword,
                                   BindingResult result){
        String property = environment.getProperty("message_pw.length.error");
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User userFromBD = userService.findByUsername(name);
        System.out.println(userFromBD);


        userValidator.validate(userNew, result);
        if(passwordEncoder.matches(oldPassword, userFromBD.getPassword())
                && password.equals(repeatPassword)) {
            if(result.hasErrors()){
                List<ObjectError> allErrors = result.getAllErrors();
                String errors="";
                for (ObjectError error : allErrors) {
                    errors+=" "+environment.getProperty(error.getCode());
                }
                return property;
            }else{
                userFromBD.setPassword(password);
                userEditor.setValue(userFromBD);
                userService.save(userFromBD);
            return environment.getProperty("change_password_success");
            }
        }
        else{
        return property;
        }
    }

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
