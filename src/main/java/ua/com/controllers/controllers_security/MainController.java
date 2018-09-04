package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.dao.AuctionItemsDao;
import ua.com.dao.UserDao;
import ua.com.editor.UserValidator;
import ua.com.editor.UserEditor;
import ua.com.entity.AuctionItems;
import ua.com.entity.User;
import ua.com.service.UserService;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@PropertySource("classpath:validation.properties")
public class MainController {

    @Autowired
    private Environment environment;

    @GetMapping("/")
        public String start (){
            return "home" ;
        }

    @GetMapping("/home")
        public String home (){
            return "home" ;
        }

    @GetMapping("/error")
        public String error (){
            return "error" ;
        }

    @GetMapping("/goToCabinet")
        private String goToCabinet(){
        return "cabinet";
    }



        @Autowired
        private UserService userService;
    @Autowired
    private UserDao userDao;

    @Autowired
        private UserEditor userEditor;
    @Autowired
        UserValidator userValidator;
    @Autowired
        private AuctionItemsDao auctionItemsDao;
    @PostMapping("/save")
        public String  save (User user,
                             @RequestParam String psw_repeat,
                             BindingResult result,
                             Model model){

        userValidator.validate(user,result);
        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            String errorMessage = "";
            for (ObjectError error : allErrors) {
                errorMessage+=" "+environment.getProperty(error.getCode());
            }
            model.addAttribute("error",errorMessage);

            return "home";
        }
        if(user.getPassword().equals(psw_repeat)) {
            userEditor.setValue(user);
            userService.save(user);
        }


        return "home";
        }

        @GetMapping("goToSale")
        private String goToSale(){
        return "sale";
        }

        @PostMapping("/createAuctionItem")
        private String createAuctionItem(AuctionItems auctionItems){
            LocalDateTime dateNow = LocalDateTime.now();

            auctionItemsDao.save(auctionItems);

            return "sale";
        }

        @PostMapping("/ok")
            public String ok (@RequestParam String username,
                              Model model){
            UserDetails userDetails = userService.loadUserByUsername(username);
//            String username1 = userDetails.getUsername();
            model.addAttribute("user",userDetails.getUsername());

            return "cabinet" ;
            }

}
