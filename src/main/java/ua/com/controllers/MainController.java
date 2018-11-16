package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.dao.AuctionItemsDao;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.Basket;
import ua.com.entity.CommonCategory;
import ua.com.entity.SubCategory;
import ua.com.entity.User;

import java.util.List;
import java.util.Scanner;

@Controller
public class MainController{
@Autowired
    CommonCategoryDao commonCategoryDao;
@Autowired
    SubCategoryDao subCategoryDao;

    @GetMapping("/goToCabinet")
    private String goToCabinet(){
        return "cabinet";
    }

    @GetMapping("goToSale")
    private String goToSale(){
        return "sale";
    }

    @GetMapping("/fromLogoToHome")
    private String fromLogoToHome(){
        return "home";
    }

    @GetMapping("/goLostPsw")
    private String goLostPsw(){
        return "lostpassword";
    }


////////////////////////////////////////////////////////////////
    @GetMapping("/goToLot")
    private String goToLot(){
        return "lot";
    }

    @GetMapping("/goToHome")
    private String goToHome(){
        return "home";
    }

    @GetMapping("/goToCart")
    private String goToCart(){
        return "cart";
    }

@GetMapping("/save")
public String home(Model model){
    return "save";
}

    @GetMapping("/delete")
    public String delete(Model model){
        return "delete";
    }

    @GetMapping("/restp")
    public String restp(){
        return "restp";
    }

    @ModelAttribute("userModel")
    public User user(){
        return new User();
    }

    @GetMapping("/cart")
    public String goCart(){
        return "cart";
    }

    @GetMapping("/aukcion")
    public String goAukcion(){
        return "aukcion";
    }

    @GetMapping("/lot")
    public String goLot(){
        return "lot";
    }

}
