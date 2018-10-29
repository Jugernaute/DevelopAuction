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
private ImageLinkService imageLinkService;
@Autowired
private LotService lotService;
@Autowired
private ProductService productService;

    @GetMapping("/")
        public String start (Model model){

//        int id_product = lotService.getLotById(1).getProduct().getId_Product();
//        System.out.println(id_product);
//        if(id_product == 0 ){
//            System.out.println("null id product");
//            return "home";
//        }
        List<Product> allProduct = productService.findAllProduct();
        List<String>imgNew=new ArrayList<>();

        List<Product> sortedProduct = allProduct.stream()
                .filter(p -> LocalDateTime.now().isBefore(p.getLot().getDataStartLot()))
                .sorted(Comparator.comparing(o -> o.getLot().getDataStartLot()))
                .collect(Collectors.toList());

        List<ImageLink> imgLink = new ArrayList<>();
        for (Product product : sortedProduct) {
            List<ImageLink> imageLinks = product.getImageLinks();
            ImageLink imageLink = imageLinks.get(0);
            imgLink.add(imageLink);
        }

//        for (Product product : allProduct) {
//            LocalDateTime dataStartLot = product.getLot().getDataStartLot();
//            LocalDateTime dataTimeNow = LocalDateTime.now();
//
//            if(dataTimeNow.isBefore(dataStartLot)){
//                List<ImageLink> imageLinks = product.getImageLinks();
////                imageLinks.stream().
//                ImageLink imageLink = imageLinks.get(0);
//                String linkOfImage = imageLink.getLinkOfImage();
//                imgNew.add(linkOfImage);
//            }
//        }

        model.addAttribute("imgLinks", imgLink);
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
