package ua.com.controllers;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.editor.UserEditor;
import ua.com.editor.UserValidator;
import ua.com.entity.*;
import ua.com.method.LoadAllLotOnMainPage;
import ua.com.method.LoadAllLotOnPageUsingRest;
import ua.com.method.error_log.Logs;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.subcategory.SubCategoryService;
import ua.com.service.user.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@PropertySource("classpath:validation.properties")
public class RestMainController {
    @Autowired
    private UserService userService;
    @Autowired
    private Environment environment;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserEditor userEditor;
    @Autowired
    private CommonCategoryService commonCategoryService;
    @Autowired
    private LoadAllLotOnPageUsingRest loadAllLotOnPageUsingRest;
    @Autowired
    private LoadAllLotOnMainPage allLotOnMainPage;
    @Autowired
    private Logs logs;

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
            userService.addUser(byEmail);
            return environment.getProperty("change_password_success");
        }
        else{
            return property;
        }
    }

    @GetMapping("category/{nameCategory}")
    private Map categoryList(@PathVariable String nameCategory){
        List<ImageLink> linkList = allLotOnMainPage.loadAllLotOnMainPage(nameCategory);
        return loadAllLotOnPageUsingRest.loadAllLotOnPageUsingRest(linkList);
    }
}
