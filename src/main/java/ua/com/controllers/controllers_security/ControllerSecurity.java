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
import ua.com.entity.*;
import ua.com.method.LoadAllLotOnMainPage;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.imageLink.ImageLinkService;
import ua.com.service.lot.LotService;
import ua.com.service.product.ProductService;
import ua.com.service.subcategory.SubCategoryService;
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
    @Autowired
    private CommonCategoryService commonCategoryService;
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/")
        public String start (Model model){

        List list = allLotOnMainPage.loadAllLotOnMainPage();
        List<CommonCategory> allCommonCategory = commonCategoryService.findAllCommonCategory();
//        DateTimeFormatter ru = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss").withLocale(new Locale("ru"));
//        for (CommonCategory commonCategory : allCommonCategory) {
//            commonCategory.getId_CommonCategory()
//        }
        model.addAttribute("imgLinks", list);
        model.addAttribute("commonList", allCommonCategory);
        return "main" ;
        }

//    @GetMapping("/category/{idCategory}")
//    public String redirectOnList (@PathVariable String idCategory,
//                                  Model model){
//        List<SubCategory> subCategoryList = commonCategoryService.getCommonCategoryById(Integer.parseInt(idCategory)).getSubCategoryList();
//        model.addAttribute("subCategory", subCategoryList);
//
//        return "categoryLotList";
//    }

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

            model.addAttribute("imgLinks", list);
            model.addAttribute("user",user);

            return "homeregisterUser";
            }

}
