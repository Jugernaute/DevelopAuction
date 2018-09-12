package ua.com.controllers.controllers_change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.editor.UserEditor;
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
    @Autowired
    private UserEditor userEditor;
    @Autowired
    private PasswordEncoder passwordEncoder;


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
    private String changePassword( User user,
                                  @RequestParam String password,
                                  @RequestParam String oldPassword,
                                  @RequestParam String repeatPassword,
                                  Model model,
                                  BindingResult result){
        String property = environment.getProperty("message_pw.length.error");
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User users = userService.findByUsername(name);
//        System.out.println(user.getPassword());
//        System.out.println(password+" password");
//        System.out.println(oldPassword+" oldPassword");
//        System.out.println(repeatPassword+" repeatPassword");
        if(passwordEncoder.matches(oldPassword, users.getPassword())
                && password.equals(repeatPassword)) {
            userValidator.validate(user, result);
            if(result.hasErrors()){
                List<ObjectError> allErrors = result.getAllErrors();
                String errors="";
                for (ObjectError error : allErrors) {
                    errors+=" "+environment.getProperty(error.getCode());
                }
                model.addAttribute("errors",errors);

            }else{
                model.addAttribute("errors","ви змінили пароль");
            }
        }
        else{
            model.addAttribute("error",property);
        }
        model.addAttribute("user",users);
        userEditor.setValue(user);

        String a = "pasha";
        String encode = passwordEncoder.encode(a);
        passwordEncoder.matches(a, encode);
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
