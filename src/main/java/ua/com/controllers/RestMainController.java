package ua.com.controllers;

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
import ua.com.method.abstracts.ListImageLinks;
import ua.com.service.user.UserService;

import java.util.*;


@RestController
@PropertySource("classpath:validation.properties")
public class RestMainController extends ListImageLinks {
    @Autowired
    private UserService userService;
    @Autowired
    private Environment environment;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserEditor userEditor;
    @Autowired
    private LoadAllLotOnPageUsingRest loadAllLotOnPageUsingRest;
    @Autowired
    private LoadAllLotOnMainPage allLotOnMainPage;


    @PostMapping("enterKey")
    private String lost_password_ok(
            @RequestParam String randomStr,
            @RequestParam String email){
//        System.out.println(randomStr + " " + email);
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

    /*from main.js*/
    @PostMapping("main/select")
    private Map mainSelect(@RequestParam String select){
        /*
       @select="0" Виберіть
       @select="1" Всі аукціони
       @select="2" Аукціони, що вже тривають
       @select="3" Завершені аукціони
       @select="4" Ще не розпочаті аукціони*/
        try{
            int option = Integer.parseInt(select);
            List<ImageLink> imageLinks = allLotOnMainPage.loadAllLotOnMainPage(option);
            return loadAllLotOnPageUsingRest.loadAllLotOnPageUsingRest(imageLinks);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new HashMap();
        /*return on main.js*/
    }

    /*from main.js*/
    @PostMapping("main/search")
    private Map<Integer, Map<String,String>> search (@RequestParam String search_text){
        List<ImageLink> imageLinkList = imageLinks(search_text);
        return loadAllLotOnPageUsingRest.loadAllLotOnPageUsingRest(imageLinkList);
    }
}
