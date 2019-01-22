package ua.com.controllers.controllers_security;

import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionCreator;
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
import ua.com.entity.ImageLink;
import ua.com.entity.Lot;
import ua.com.entity.Product;
import ua.com.entity.User;
import ua.com.method.LoadAllLotOnMainPage;
import ua.com.service.imageLink.ImageLinkService;
import ua.com.service.lot.LotService;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;

import javax.management.Query;
import javax.naming.Context;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@PropertySource("classpath:validation.properties")
    public class ControllerSecurity {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoadAllLotOnMainPage allLotOnMainPage;

    @GetMapping("/")
        public String start (Model model){

        List list = allLotOnMainPage.loadAllLotOnMainPage();
        DateTimeFormatter ru = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss").withLocale(new Locale("ru"));
//        System.out.println(ru.format(dataEndLot));
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
    public String ok(User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            return "admin";
        }
        return "cabinet";
    }
}
