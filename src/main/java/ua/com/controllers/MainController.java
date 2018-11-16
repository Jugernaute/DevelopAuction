package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.dao.AuctionItemsDao;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.CommonCategory;
import ua.com.entity.SubCategory;
import ua.com.entity.User;

import java.util.List;

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

    @GetMapping("/goToFb")
    private String goToFb(){
        return "pagefb";
    }

}