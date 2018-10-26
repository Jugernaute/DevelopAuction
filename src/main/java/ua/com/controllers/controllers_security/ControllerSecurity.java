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
import java.util.List;

@Controller
@PropertySource("classpath:validation.properties")
public class ControllerSecurity {
@Autowired
private ImageLinkService imageLinkService;
@Autowired
private LotService lotService;
@Autowired
private ProductService productService;

    @GetMapping("/")
        public String start (Model model){

        int id_product = lotService.getLotById(1).getProduct().getId_Product();
        System.out.println(id_product);
        if(id_product == 0 ){
            System.out.println("null id product");
            return "home";
        }
        List<ImageLink> all = imageLinkService.findAll();
        System.out.println(all);
        for (ImageLink imageLink : all) {
//            int startPrice = imageLink.getProduct().getId_Product().getLot().getStartPrice();
//            if (tmp==id_product){
//                model.addAttribute("imgLinks", all);
//                return "home";
//            }
        }
        model.addAttribute("imgLinks", all);
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
            userService.addUser(user);
        }
        return "home";
    }


        @PostMapping("/ok")
            public String ok (Model model){
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.findByUsername(name);
            model.addAttribute("user",user);
            return "cabinet";
            }

}
