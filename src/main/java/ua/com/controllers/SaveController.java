package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.dao.*;
import ua.com.entity.*;
import ua.com.service.bet.BetService;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.delivery.DeliveryService;
import ua.com.service.lot.LotService;
import ua.com.service.manufacturer.ManufacturerService;
import ua.com.service.payment.PaymentService;
import ua.com.service.product.ProductService;
import ua.com.service.subcategory.SubСategoryService;
import ua.com.service.user.UserService;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static java.io.File.separator;

@Controller
@RequestMapping("/save")
public class SaveController {


    @Autowired
    private UserService userService;
    @Autowired
    private BetService betService;
    @Autowired
    private CommonCategoryService commonCategoryService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private LotService lotService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SubСategoryService subСategoryService;

    @Autowired
    private LotDao lotDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private DeliveryDao deliveryDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ManufacturerDao manufacturerDao;
    @Autowired
    private SubCategoryDao subCategoryDao;
    @Autowired
    private CommonCategoryDao commonCategoryDao;
    @Autowired
    private BetDao betDao;

    @PostMapping("/user")
    public String saveUser(User user){
        userService.save(user);
        return "save";
    }

    @PostMapping("/delete/user")
    public String deleteUser(User user){
        userService.deleteBuId(1);
        return "delete";
    }

    @PostMapping("/lot")
    public String saveLot(@RequestParam int id_Delivery, @RequestParam int id_Product, @RequestParam int id_Payment, Lot lot){
        Delivery delivery = deliveryDao.findOne(id_Delivery);
        Product product = productDao.findOne(id_Product);
        Payment payment = paymentDao.findOne(id_Payment);
        lotService.save(lot);
        return "save";
    }


    @PostMapping("/bet")
    public String saveBet(@RequestParam int id_Lot, @RequestParam int userId, Bet bet){
        Lot lot = lotDao.findOne(id_Lot);
        User user = userDao.findOne(userId);
        betService.save(bet);
        return "save";
    }



    @PostMapping("/delivery")
    public String saveDelivery(Delivery delivery){
        deliveryService.save(delivery);
        return "save";
    }

    public SaveController() {
    }

    @PostMapping("/manufacturer")
    public String saveManufacturer(Manufacturer manufacturer){
        manufacturerService.save(manufacturer);
        return "save";
    }

    @PostMapping("/payment")
    public String savePayment(Payment payment){
        paymentService.save(payment);
        return "save";
    }

    @PostMapping("/product")
    public String saveProduct(@RequestParam int id_Manufacturer, @RequestParam int id_SubCategory, @RequestParam int userId, Product product, @RequestParam ("file")MultipartFile file) throws IOException {
        System.out.println(System.getProperty("user.home"));
        file.transferTo(
                new File
                        (System.getProperty("user.home")
                        + separator +
                        "pics"
                        + separator +
                        file.getOriginalFilename()));
        product.setLinkOnImageProduct("/prefixForAva/" + file.getOriginalFilename());
        Manufacturer manufacturer = manufacturerDao.findOne(id_Manufacturer);
        SubCategory subCategory = subCategoryDao.findOne(id_SubCategory);
        User user = userDao.findOne(userId);
        productService.save(product);
        return "save";
    }

//    @PostMapping("/product/in/basket")
//    public String saveProductInBasket(@RequestParam int id_Manufacturer, @RequestParam int id_SubCategory, @RequestParam int userId, Product product, @RequestParam ("file")MultipartFile file) throws IOException {
//        System.out.println(System.getProperty("user.home"));
//        file.transferTo(
//                new File
//                        (System.getProperty("user.home")
//                                + separator +
//                                "pics"
//                                + separator +
//                                file.getOriginalFilename()));
//        product.setLinkOnImageProduct("/prefixForAva/" + file.getOriginalFilename());
//        Manufacturer manufacturer = manufacturerDao.findOne(id_Manufacturer);
//        SubCategory subCategory = subCategoryDao.findOne(id_SubCategory);
//        User user = userDao.findOne(userId);
//        productService.addProduct(product.setSubCategory(subCategory).setManufacturer(manufacturer).setUserOwner(user));
//        return "basket";
//    }

    @PostMapping("/commonCategory")
    public String saveCommonCategory(CommonCategory commonCategory){
        commonCategoryService.addCommonCategory(commonCategory);
        return "save";
    }

    @PostMapping("/subCategory")
    public String saveSubCategory(@RequestParam int id_CommonCategory, SubCategory subCategory){
        CommonCategory commonCategory = commonCategoryDao.findOne(id_CommonCategory);
        subСategoryService.addSubcategory(subCategory);
        return "save";
    }
    @ModelAttribute("userModel")
    public User user(){
        return new User();
    }
}
