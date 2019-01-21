package ua.com.controllers.controllers_security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.entity.*;
import ua.com.method.FillFilter_CommonCategory_OnRegisterUserPage;
import ua.com.method.LoadAllLotOnMainPage;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@PropertySource("classpath:validation.properties")

    public class ControllerSecurity {

    private static final Logger logger = Logger.getLogger(ControllerSecurity.class.getSimpleName());
//    private FileHandler fileHandler = new FileHandler();

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoadAllLotOnMainPage allLotOnMainPage;
    @Autowired
    private CommonCategoryService commonCategoryService;
    @Autowired
    private FillFilter_CommonCategory_OnRegisterUserPage fillFilterCommonCategoryOnRegisterUserPage;

    public ControllerSecurity() throws IOException {
    }

    @GetMapping("/")
        public String start (Model model) throws IOException {
        List list = allLotOnMainPage.loadAllLotOnMainPage();
        DateTimeFormatter ru = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss").withLocale(new Locale("ru"));

        List<CommonCategory> allCommonCategory = commonCategoryService.findAllCommonCategory();
        model.addAttribute("commonList", allCommonCategory);
        model.addAttribute("dataNow", LocalDateTime.now());

        model.addAttribute("imgLinks", list);
        return "main" ;
        }

    @GetMapping("/home")
        public String home (){
            return "homeregisterUser" ;
        }

    @GetMapping("/error")
        public String error (){
            return "error" ;
        }

    @GetMapping("/logout")
        public String logout(){
        return "redirect:/";
    }


    @GetMapping("/qwe")
    public String qwe(){
        return "qwe";
    }

    @GetMapping("/activate/{key}")
    public String activate(@PathVariable String key,
                           Model model) {
        User user = userService.findByRandomKey(key);
        if(!(user ==null)&&!(user.getRandomKey()==null)){
            user.setRandomKey(null);
            user.setEnabled(true);
            userService.addUser(user);
        }else{
            return "/errorPage/registration_error";
        }
        model.addAttribute("user", user);
        return "homeregisterUser";
    }


        @PostMapping("/ok")
            public String ok (Model model){
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.findByUsername(name);

                if (user.getRandomKey()!=null){
                    return  "/errorPage/activation_error";
                }

            List list = allLotOnMainPage.loadAllLotOnMainPage();
            List<CommonCategory> allCommonCategory = commonCategoryService.findAllCommonCategory();
            for (CommonCategory commonCategory : allCommonCategory) {
                System.out.println("name common category" +commonCategory.getNameCommonCategory());
            }
            Map map = fillFilterCommonCategoryOnRegisterUserPage.fillFilterOnRegisterUserPage(allCommonCategory);

            model.addAttribute("commonList", allCommonCategory);
            model.addAttribute("commonMap", map);
            model.addAttribute("imgLinks", list);
            model.addAttribute("user",user);

            return "homeregisterUser";
            }

}
