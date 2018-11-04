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
import ua.com.entity.Product;
import ua.com.entity.User;
import ua.com.service.imageLink.ImageLinkService;
import ua.com.service.lot.LotService;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;

import javax.management.Query;
import javax.naming.Context;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@PropertySource("classpath:validation.properties")
    public class ControllerSecurity {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
        public String start (Model model){

        List<Product> allProduct = productService.findAllProduct();

        List<ImageLink> imgLink = new ArrayList<>();
        for (Product product : allProduct) {
            List<ImageLink> imageLinks = product.getImageLinks();
//            System.out.println("----"+imageLinks);
            if (!(imageLinks.size() == 0)){
                ImageLink imageLink = imageLinks.get(0);
                imgLink.add(imageLink);
            }else {
                System.out.println("----error----");
            }
        }
        model.addAttribute("imgLinks", imgLink);
        return "home" ;
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
    public String activate(@PathVariable String key) {
        User user = userService.findByRandomKey(key);
        if(!(user ==null)){
            user.setRandomKey(null);
            user.setEnabled(true);
            userService.addUser(user);
        }
        return "homeregisterUser";
    }


        @PostMapping("/ok")
            public String ok (Model model){
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.findByUsername(name);


            List<Product> allProduct = productService.findAllProduct();
            List<ImageLink> imgLink = new ArrayList<>();
            for (Product product : allProduct) {
                List<ImageLink> imageLinks = product.getImageLinks();
//            System.out.println("----"+imageLinks);
                if (!(imageLinks.size() == 0)){
                    ImageLink imageLink = imageLinks.get(0);
                    imgLink.add(imageLink);
                }else {
                    System.out.println("---error---");
                }

            }
            model.addAttribute("imgLinks", imgLink);
            model.addAttribute("user",user);
            return "homeregisterUser";
            }

}
