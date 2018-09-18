package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.dao.AuctionItemsDao;
import ua.com.entity.User;
import ua.com.service.user.UserService;

@Controller
@PropertySource("classpath:validation.properties")
public class ControllerSecurity {


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

    @GetMapping("/logout")
        public String logout(){
        return "home";
    }


    @GetMapping("/qwe")
    public String qwe(){
        return "qwe";
    }

    @Autowired
    private UserService userService;

    @Autowired
        private AuctionItemsDao auctionItemsDao;

    @GetMapping("/activate/{key}")
    public String activate(@PathVariable String key,
                           Model model) {
        User user = userService.findByRandomKey(key);
        if(!(user ==null)){
            user.setRandomKey(null);
            user.setEnabled(true);
            userService.save(user);
        }
        return "home";
    }


        @PostMapping("/ok")
            public String ok (){
            return "cabinet";
            }

}
