package ua.com.controllers.controllers_change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.editor.UserValidator;
import ua.com.entity.User;
import ua.com.method.Mail;
import ua.com.method.RandomStr;
import ua.com.service.UserService;

import java.util.List;

@Controller
@PropertySource("classpath:validation.properties")
public class ControllerChange {

    @Autowired
    private Environment environment;
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private Mail mail;


    @PostMapping("/change_Email")
    private String changeEmail(@RequestParam String email,
                               Model model){
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setEmail(email);
        userService.save(user);
        model.addAttribute("user",user);
        return "cabinet";
    }

    @PostMapping("/change_Password")
    private String changePassword(@RequestParam String oldPassword,
                                  @RequestParam String newPassword,
                                  @RequestParam String repeatPassword,
                                  Model model
                                  /*BindingResult result*/){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        System.out.println(user);
//        userValidator.validatePasswordChange(user, oldPassword, result);
//        if(result.hasErrors()){
//            List<ObjectError> allErrors = result.getAllErrors();
//            String errors="";
//            System.out.println(errors);
//            for (ObjectError error : allErrors) {
//               errors+=" "+environment.getProperty(error.getCode());
//            }
//            model.addAttribute("errors",errors);
//        }

//        userValidator.validate(user,result);
        if(newPassword.equals(repeatPassword) && oldPassword.equals(user.getPassword())){
            user.setPassword(newPassword);
        }else{
            model.addAttribute("errors","your password isn't validate");
        }

        model.addAttribute("user",user);
        return "cabinet";
    }

    @PostMapping("change_Phone")
    private String changePone(@RequestParam String phone,
                              Model model){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        user.setPhone(phone);
        userService.save(user);
        model.addAttribute("user",user);
        return "cabinet";
    }

    @PostMapping("sendKey")
    private String forgot_pw(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        String s = RandomStr.randomKey();
        User user = userService.findByUsername(name);
        user.setRandomKey(s);
        String email = user.getEmail();
        String subjectForgotPassword = "Підтвердження дій для зміни пароля";
        String text = "Your key for change password: "+ s;
        mail.sendMail(email,subjectForgotPassword,text);
        userService.save(user);
        return "cabinet";
    }

    @PostMapping("forgot_psw")
    private String enterKey(@RequestParam String key,
                            Model model){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        if(user.getRandomKey().equals(key)){
            model.addAttribute("key","your key is validate, enter new password now");
            return "cabinet";
        }else{
            model.addAttribute("key","your key is not validate");
            return "error";
        }
    }
}
