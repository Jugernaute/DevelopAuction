package ua.com.controllers.controllers_cabinet;

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
import ua.com.entity.Location;
import ua.com.entity.User;
import ua.com.method.Mail;
import ua.com.method.RandomStr;
import ua.com.service.location.LocationService;
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
    @Autowired
    private LocationService locationService;

    @PostMapping("/change_Email")
    public String user(
                        @RequestParam String randomKey,
                        @RequestParam String email){
//                       @AuthenticationPrincipal User user,){
        User byRandomKey = userService.findByRandomKey(randomKey);
        System.out.println(randomKey);
        System.out.println(mail);
        if(byRandomKey!=null){
            byRandomKey.setRandomKey("");
            byRandomKey.setEmail(email);
            userService.addUser(byRandomKey);
            return environment.getProperty("change_e-mail_success");
        }
        return "something error";
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
            userService.addUser(byEmail);
            mail.sendMail(email,subjectForgotPassword,text);
        }
        else if(email!=null && !(name.equals("anonymousUser")))
        {
//            User user = userService.findByUsername(name);
//            user.setRandomKey(s);
//            String userEmail = user.getEmail();
            mail.sendMail(email,subjectForgotPassword,text);
        }
    }

    @GetMapping("/getCurrent_Email_Phone_Username")
    public Map<String, String> getCurrentEmail(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User byUsername = userService.findByUsername(name);
        List<Location> userLocation = byUsername.getLocation();
        Map<String,String>list = new LinkedHashMap<>();
        for (Location location1 : userLocation) {
            list.put("country", location1.getCountry());
            list.put("state", location1.getRegion());
            list.put("city", location1.getCity());
            list.put("postAddress", location1.getUserPostAddress());
        }
        list.put("email",byUsername.getEmail());
        list.put("phone",byUsername.getPhone());
        list.put("username",byUsername.getUsername());
        list.put("firstname",byUsername.getFirstNameUser());
        list.put("surname",byUsername.getSurNameUser());
        list.put("about",byUsername.getAboutMe());
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
        userService.addUser(user);
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
        userService.addUser(user);
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
        userService.addUser(user);
        return user.getSurNameUser();
    }

    @PostMapping("/savePostAddress")
    private void savePostAddress(@RequestParam String address,
                                   @RequestParam String country,
                                   @RequestParam String cities,
                                   @RequestParam String state
    ){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        List<Location> userLocation = user.getLocation();
        for (Location location1 : userLocation) {
            location1.setRegion(state);
            location1.setCountry(country);
            location1.setCity(cities);
            location1.setUser(Collections.singletonList(user));
            location1.setUserPostAddress(address);
            locationService.addLocation(location1);
        }
        user.setLocation(userLocation);
        userService.addUser(user);
    }

    @PutMapping("changeAboutMe")
    private String AboutMe(@RequestBody String aboutMe,
                           Location location){
        System.out.println(aboutMe.length());
        if(aboutMe.length()>50){
            return environment.getProperty("aboutMe_Max_Symbols");
        }
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        user.setAboutMe(aboutMe);

        userService.addUser(user);

        return "description success save";
    }
}
