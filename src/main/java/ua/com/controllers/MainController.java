package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.controllers.controllers_security.ControllerSecurity;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.*;
import ua.com.method.LiderAndSizeOfBets;
import ua.com.method.LoadAllLotOnMainPage;
import ua.com.service.bet.BetService;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;
import java.time.*;
import java.util.*;

@Controller
public class MainController{
@Autowired
    CommonCategoryDao commonCategoryDao;
@Autowired
    SubCategoryDao subCategoryDao;
@Autowired
    private ProductService productService;
@Autowired
    private LoadAllLotOnMainPage  allLotOnMainPage;
    @Autowired
    private UserService userService;
    @Autowired
    private LiderAndSizeOfBets liderAndSizeOfBets;


    @GetMapping("/goToCabinet")
    private String goToCabinet(Model model){
        String userSession = SecurityContextHolder.getContext().getAuthentication().getName();
        User username = userService.findByUsername(userSession);
        model.addAttribute("user",username);
        return "cabinet";
    }

    @GetMapping("/fromLogoToHome")
    private String fromLogoToHome(Model model){
        String userSession = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(userSession);
        System.out.println(userSession);
        if (!userSession.equals("anonymousUser")){
            if (user.getRandomKey()!=null){
                return  "/errorPage/activation_error";
            }
            List<ImageLink> list = allLotOnMainPage.loadAllLotOnMainPage();

            model.addAttribute("imgLinks", list);
            model.addAttribute("user",user);

            return "homeregisterUser";
        }else{
            return "redirect:/";
        }

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

        /*
        * Call from method's directory
        * */
        Map<String,String> map = liderAndSizeOfBets.Lider(id_lot);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> next : entries) {
            /*
            * return for key -> betsLot
            * return for key -> userLider*/
            model.addAttribute(next.getKey(), next.getValue());
        }

        String userCreateLot = userService.findUserByProductId(id).getUsername();
        String userFromSession = SecurityContextHolder.getContext().getAuthentication().getName();


        model.addAttribute("data", dataEndLot);
        model.addAttribute("product", productById);
        model.addAttribute("location", locationLots);
        model.addAttribute("nameSub", nameSubcategory);
        model.addAttribute("nameCom", nameCommonCategory);
        model.addAttribute("nextPrice", nextPrice);
        model.addAttribute("userCreateLot", userCreateLot);
        model.addAttribute("userFromSession", userFromSession);
        model.addAttribute("hotPrice", hotPrice);
        return "lot&bet";
    }


}