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
import ua.com.service.locationLot.LocationLotService;
import ua.com.service.product.ProductService;

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
    private LocationLotService locationLotService;
@Autowired
    private EntityManager entityManager;

    @GetMapping("/goToCabinet")
    private String goToCabinet(){ return "cabinet";
    }

//    @GetMapping("goToSell")
//    private String goToSale(){
//        return "sell";
//    }

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
                       Model model,
                       RedirectAttributes attributes){
        attributes.addFlashAttribute("id",idProduct);
        Product productById = productService.getProductById(idProduct);

        LocalDateTime dataEndLot = productById.getLot().getDataEndLot();
//        int dataEndLot2 = productById.getLot().getDataEndLot().getSecond();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE ddMMM yyyy HH:mm");
//        ZonedDateTime zonedDateTime = dataEndLot.atZone(ZoneId.of("Europe/Moscow"));
//        long l = zonedDateTime.toInstant().toEpochMilli()/1000;
//        System.out.println("---------"+l);
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(l), ZoneId.systemDefault());
//        System.out.println(localDateTime.toString()+"==");
//        Duration between = Duration.between(LocalDateTime.now(), dataEndLot);
//
//        long seconds = between.getSeconds();
//        System.out.println(seconds);
//        System.out.println(dataEndLot);

//        LocalDateTime now = LocalDateTime.now();
//        Duration between = Duration.between(dataEndLot, now);
//        long s = between.getSeconds();
//        LocalDateTime epochSecond = LocalDateTime.ofInstant(Instant.ofEpochSecond(s), ZoneId.systemDefault());
//        System.out.println("day---------" + epochSecond.getDayOfWeek());
//        String data = dataEndLot .format(formatter);
//        System.out.println(data);
        int id = productById.getId_Product();
        String nameSubcategory ="SELECT nameSubCategory from subcategory join product p on subcategory.id_SubCategory = p.subCategory_id_SubCategory where id_Product="+id;

        Object singleResult = entityManager.createNativeQuery(nameSubcategory).getSingleResult();


        SubCategory byNameSubCategory = subCategoryDao.findByNameSubCategory(singleResult.toString());
        int id_Sub = byNameSubCategory.getId_SubCategory();
        String nameCommonCategory = "select nameCommonCategory from commoncategory join subcategory s " +
                "on commoncategory.id_CommonCategory = s.commonCategory_id_CommonCategory where id_SubCategory="+id_Sub;
        Object singleResult2 = entityManager.createNativeQuery(nameCommonCategory).getSingleResult();

        LocationLot locationLots = productById.getLocationLots();

        List<ImageLink> imageLinks = productById.getImageLinks();
        int x=0;
        for (ImageLink imageLink : imageLinks) {
            x =x+1;
            model.addAttribute("image"+x, imageLink);
        }
//        redirectAttributes.addAttribute("sec", second);
        model.addAttribute("data", dataEndLot);
        model.addAttribute("product", productById);
        model.addAttribute("location", locationLots);
        model.addAttribute("nameSub", singleResult);
        model.addAttribute("nameCom", singleResult2);
//        model.addAttribute("sec", l);
        return "lot";
    }


//    @PostMapping("lot/{idProduct}/betUp")
//    private String lotSec(
//                          @PathVariable String idProduct,
//                          @RequestBody String betUp,
//                          RedirectAttributes attributes){
//
//        System.out.println(idProduct);
//        System.out.println(betUp);
//
//        return "lot";
//    }

}