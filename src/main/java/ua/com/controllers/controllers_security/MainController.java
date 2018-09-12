package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.dao.AuctionItemsDao;
import ua.com.dao.UserDao;
import ua.com.editor.UserValidator;
import ua.com.editor.UserEditor;
import ua.com.entity.AuctionItems;
import ua.com.entity.User;
import ua.com.method.Mail;
import ua.com.method.RandomStr;
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

    @GetMapping("goToSale")
    private String goToSale(){
        return "sale";
    }



    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @Autowired
        private UserEditor userEditor;
    @Autowired
        private UserValidator userValidator;
    @Autowired
        private AuctionItemsDao auctionItemsDao;
    @Autowired
        private Mail mail;


    @PostMapping("/save")
        public String  save (User user,
                             @RequestParam String psw_repeat,
                             @RequestParam String email,
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
            user.setEmail(email);
//Генерація і відправка ключа реєстрації на пошту клієнта
            String randomKey = RandomStr.randomKey();
            user.setRandomKey(randomKey);
            userEditor.setValue(user);
            userService.save(user);
            String text = "Good day, " + user.getUsername() + " "
                    +"Activate account : <a href='http://localhost:8080/activate/"
                    + randomKey
                    + "'>Activate</a>";
            String subject = "Підтвердження акаунту на Auction";
            mail.sendMail(email,subject,text);
        }
        if(!user.isEnabled()){
            return "activation";
        }
        return "home";
        }

    @GetMapping("/activate/{key}")
    public String activate(@PathVariable String key,
                           Model model) {
        User user = userService.findByRandomKey(key);
        if(!(user ==null)){
            user.setRandomKey(null);
            user.setEnabled(true);
            userService.save(user);
        }

        model.addAttribute("user",user);
        return "cabinet";
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
            String name = auth.getName(); //get logged in username
            User user = userService.findByUsername(name);
            model.addAttribute("user",user);
            return "cabinet";
            }

}
