package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.dao.AuctionItemsDao;

@Controller
public class MainController{

    @Autowired
    private AuctionItemsDao auctionItemsDao;

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

//    @PostMapping("/createAuctionItem")
//    private String createAuctionItem(AuctionItems auctionItems){
//        LocalDateTime dateNow = LocalDateTime.now();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName(); //get logged in username
//        auctionItemsDao.save(auctionItems);
//        return "sell";
//    }
}