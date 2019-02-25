package ua.com.controllers.controllers_security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.entity.*;
import ua.com.method.FillFilter_CommonCategory_OnRegisterUserPage;
import ua.com.method.LoadAllLotOnMainPage;
import ua.com.method.Mail;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
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
    private Environment environment;
    @Autowired
    private Mail mail;
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
//        String text = "Hello You win SUZUKI GRAND VITARA)) To confirm your winnings, go to this link <a href='https://picua.org/image/20190214-214221.xHrjsc'>CLICK ME</a>";
//        String subject = environment.getProperty("textForMailSender_String_subject");
//        String email = "vprokopishin76@gmail.com";
//        for (int i = 0; i < 20; i++) {
//            mail.sendMail(email,subject,text);
//        }
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
    public String activate(@PathVariable String key/*,
                           Model model*/) {
        User user = userService.findByRandomKey(key);
        if(!(user ==null)&&!(user.getRandomKey()==null )){
            user.setRandomKey(null);
            user.setEnabled(true);
            userService.addUser(user);
        }else{
            return "/errorPage/registration_error";
        }
//        model.addAttribute("user", user);
        return "main";
    }


        @PostMapping("/ok")
            public String ok (HttpServletRequest httpServletRequest,
                              Model model){
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.findByUsername(name);

            if (user.getRandomKey()!=null){
                return  "/errorPage/activation_error";
            }

            if(user.getRole().equals(Role.ROLE_ADMIN)) {
                return "admin";
            }
            else if(user.getRole().equals(Role.ROLE_USER)) {
                List list = allLotOnMainPage.loadAllLotOnMainPage();
                List<CommonCategory> allCommonCategory = commonCategoryService.findAllCommonCategory();

                Map map = fillFilterCommonCategoryOnRegisterUserPage.fillFilterOnRegisterUserPage(allCommonCategory);

                model.addAttribute("commonList", allCommonCategory);
                model.addAttribute("commonMap", map);
                model.addAttribute("imgLinks", list);
                model.addAttribute("user",user);
                return "homeregisterUser";
            }

            return "/errorPage/role_error";
            }

}
