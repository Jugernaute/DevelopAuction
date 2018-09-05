package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
//перевірка на співпадіння паролів
        if(user.getPassword().equals(psw_repeat)) {
//рендомне нікнейм для клієнта, потім може виправити в особистому кабінеті
            int b = 10000000;
            int t = (int) (Math.random() * b);
            user.setUserNick("client_"+t);

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
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName(); //get logged in username
            auctionItemsDao.save(auctionItems);
            return "sale";
        }

        @PostMapping("/ok")
            public String ok (@RequestParam String username,
                              Model model){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            String name = auth.getName(); //get logged in username
        User byUsername = userDao.findByUsername(username);

//передаємо на вюшку імя клієнта
            model.addAttribute("user",byUsername);
            System.out.println(byUsername.getUsername());
//            model.addAttribute("userNick", byUsername.getUserNick());
            return "cabinet";
            }

}
