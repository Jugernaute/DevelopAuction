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
import ua.com.service.user.UserService;

import java.util.*;

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
        userService.addUser(user);
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
                userService.addUser(userFromBD);
            return environment.getProperty("change_password_success");
            }
        }
        else{
        return property;
        }
    }

    @PutMapping("/sendKeys")
    public void userSave(@RequestBody String email) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        String s = RandomStr.randomKey();
        String subjectForgotPassword = "Підтвердження дій для зміни пароля";
        String text = "Your key for change password: "+ s;

        if(name.equals("anonymousUser") && email!=null)
        {
            User byEmail = userService.findByEmail(email);
            if(byEmail==null)
            {
                return;
            }
            byEmail.setRandomKey(s);
            userService.save(byEmail);
            mail.sendMail(email,subjectForgotPassword,text);
        }
        else if(email==null && !(name.equals("anonymousUser")))
        {
            User user = userService.findByUsername(name);
            user.setRandomKey(s);
            String userEmail = user.getEmail();
            mail.sendMail(userEmail,subjectForgotPassword,text);
        }
    }

    @GetMapping("/getCurrent_Email_Phone_Username")
    public Map<String, String> getCurrentEmail(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User byUsername = userService.findByUsername(name);
        Map<String,String>list = new LinkedHashMap<>();
        list.put("email",byUsername.getEmail());
        list.put("phone",byUsername.getPhone());
        list.put("username",byUsername.getUsername());
        list.put("firstname",byUsername.getFirstNameUser());
        list.put("surname",byUsername.getSurNameUser());
        list.put("postadsress",byUsername.getUserPostAddress());
        return list;
    }

    @PutMapping("/changeUserPhone")
    private String changePone(@RequestBody String phone
                              ){

        if(phone.length()<5){
            return "false phone";
        }
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        user.setPhone(phone);
        userService.save(user);
        return user.getPhone();
    }

    @PutMapping("/saveFirstName")
    private String saveFirstName(@RequestBody String firstNameUser
    ){
        if(firstNameUser.length()<2){
            return "false name";
        }
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        user.setFirstNameUser(firstNameUser);
        userService.save(user);
        return user.getFirstNameUser();
    }

    @PutMapping("/saveSurName")
    private String saveSurName(@RequestBody String surNameUser
    ){
        if(surNameUser.length()<2){
            return "false name";
        }
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        user.setSurNameUser(surNameUser);
        userService.save(user);
        return user.getSurNameUser();
    }

    @PutMapping("/savePostAddress")
    private String savePostAddress(@RequestBody String userPostAddress
    ){
        if(userPostAddress.length()<2){
            return "false name";
        }
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        user.setUserPostAddress(userPostAddress);
        userService.save(user);
        return user.getUserPostAddress();
    }
}
