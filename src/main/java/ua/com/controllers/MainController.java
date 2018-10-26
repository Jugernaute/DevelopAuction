package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.dao.AuctionItemsDao;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.*;
import ua.com.service.product.ProductService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class MainController{
@Autowired
    CommonCategoryDao commonCategoryDao;
@Autowired
    SubCategoryDao subCategoryDao;
@Autowired
    private ProductService productService;

    @GetMapping("/goToCabinet")
    private String goToCabinet(){ return "cabinet";
    }

//    @GetMapping("goToSell")
//    private String goToSale(){
//        return "sell";
//    }

    @GetMapping("/fromLogoToHome")
    private String fromLogoToHome(){
        return "home";
    }

    @GetMapping("/goLostPsw")
    private String goLostPsw(){
        return "lostpassword";
    }

    @GetMapping("/lot/{idProduct}")
    private String Lot(@PathVariable int idProduct,
                       Model model){
        Product productById = productService.getProductById(idProduct);
        LocalDateTime dataEndLot = productById.getLot().getDataEndLot();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEEE MMMMM yyyy HH:mm");

        LocalDateTime now = LocalDateTime.now();
        Duration between = Duration.between(dataEndLot, now);
        String data = now .format(formatter);
        System.out.println(data);
        model.addAttribute("data", between);
        model.addAttribute("product", productById);
        return "lot";
    }

}