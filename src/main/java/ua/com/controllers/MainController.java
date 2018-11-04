package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.dao.AuctionItemsDao;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.*;
import ua.com.service.bet.BetService;
import ua.com.service.locationLot.LocationLotService;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class MainController{
@Autowired
    CommonCategoryDao commonCategoryDao;
@Autowired
    SubCategoryDao subCategoryDao;
@Autowired
    private ProductService productService;
@Autowired
    private BetService betService;
    @Autowired
    private UserService userService;

    @GetMapping("/goToCabinet")
    private String goToCabinet(){ return "cabinet";
    }

    @GetMapping("/fromLogoToHome")
    private String fromLogoToHome(){
        return "redirect:/";
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
        int id_lot = productById.getLot().getId_Lot();

        int hotPrice = productById.getLot().getHotPrice();

        int id = productById.getId_Product();

        String nameSubcategory = subCategoryDao.findSubCategoryByProducts(id).getNameSubCategory();

        String nameCommonCategory = commonCategoryDao.findCommonCategoriesBySubCategory(nameSubcategory).getNameCommonCategory();

        LocationLot locationLots = productById.getLocationLots();

        List<ImageLink> imageLinks = productById.getImageLinks();
        int x=0;
        for (ImageLink imageLink : imageLinks) {
            x =x+1;
            model.addAttribute("image"+x, imageLink);
        }
        int currentPrice = productById.getLot().getCurrentPrice();
        int nextPrice = (int) Math.round(currentPrice+currentPrice*0.1);

        List<Bet> listLotBet = betService.findAllBetByLot_id(id_lot);
        int betsLot = listLotBet.size();
//        System.out.println(">>>>"+hotPrice);
        User userOwner = userService.findUserByProductId(id);
        String username = userOwner.getUsername();

        model.addAttribute("data", dataEndLot);
        model.addAttribute("product", productById);
        model.addAttribute("location", locationLots);
        model.addAttribute("nameSub", nameSubcategory);
        model.addAttribute("nameCom", nameCommonCategory);
        model.addAttribute("nextPrice", nextPrice);
        model.addAttribute("betsLot", betsLot);
        model.addAttribute("username", username);
        model.addAttribute("hotPrice", hotPrice);
        return "lot";
    }


}