package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.dao.*;
import ua.com.entity.*;
import ua.com.service.bet.BetService;
import ua.com.service.commonCategory.CommonCategoryService;
import ua.com.service.delivery.DeliveryService;
import ua.com.service.lot.LotService;
import ua.com.service.manufacturer.ManufacturerService;
import ua.com.service.payment.PaymentService;
import ua.com.service.product.ProductService;
import ua.com.service.subCategory.SubCategoryService;
import ua.com.service.user.UserService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.io.File.separator;

@RestController
public class TestRestController {

    @Autowired
    private ProductService productService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private BetService betService;
    @Autowired
    private CommonCategoryService commonCategoryService;
    @Autowired
    private LotService lotService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private UserService userService;

    @Autowired
    private ProductDao productDao;
    @Autowired
    private DeliveryDao deliveryDao;
    @Autowired
    private BetDao betDao;
    @Autowired
    private CommonCategoryDao commonCategoryDao;
    @Autowired
    private LotDao lotDao;
    @Autowired
    private ManufacturerDao manufacturerDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private SubCategoryDao subCategoryDao;
    @Autowired
    private UserDao userDao;


    @PutMapping("/addBet")
    public void addBet(@RequestParam int id_Lot, @RequestParam int userId, @RequestBody Bet bet){
        Lot lot = lotDao.findOne(id_Lot);
        User user = userDao.findOne(userId);
        betService.addBet(bet.setLot(lot).setUser(user));
    }
    @GetMapping("/allBet")
    public List<Bet> allBet(){
        return betService.findAllBet();
    }
/////////////////////////////////////////////////////////////////////
@PutMapping("/addDelivery")
public void addDeliveryMethod(@RequestBody Delivery delivery){
    deliveryService.addDelivery(delivery);
}
    @GetMapping("/allDelivery")
    public List<Delivery> allDeliveryMethod(){
        return deliveryService.findAllDelivery();
    }

/////////////////////////////////////////////////////////////////
@PutMapping("/addProduct")
public void addProductMethod(@RequestParam int id_Manufacturer, @RequestParam int id_SubCategory, @RequestParam int userId, @RequestBody Product product) {
//    file.transferTo(
//            new File
//                    (System.getProperty("user.home")
//                            + separator +
//                            "pics"
//                            + separator +
//                            file.getOriginalFilename()));
//    product.setLinkOnImageProduct("/prefixForAva/" + file.getOriginalFilename());
        Manufacturer manufacturer = manufacturerDao.findOne(id_Manufacturer);
        SubCategory subCategory = subCategoryDao.findOne(id_SubCategory);
        User user = userService.getUserById(userId);
    productService.addProduct(product.setUserOwner(user).setSubCategory(subCategory).setManufacturer(manufacturer));
}
    @GetMapping("/allProduct")
    public List<Product> allProductMethod(){
        return productService.findAllProduct();
    }

////////////////////////////////////////////////////////////////////////
@PutMapping("/addCommonCategory")
public void addCommonCategory(@RequestBody CommonCategory commonCategory){
    commonCategoryService.addCommonCategory(commonCategory);
}
    @GetMapping("/allCommonCategory")
    public List<CommonCategory> allCommonCategory(){
        return commonCategoryService.findAllCommonCategory();
    }

 //////////////////////////////////////////////////////////////////////

 @PutMapping("/addSubCategory")
    public void addSubCategory(@RequestParam int id_CommonCategory, @RequestBody SubCategory subCategory){
     System.out.println(id_CommonCategory);
     CommonCategory commonCategory = commonCategoryDao.findOne(id_CommonCategory);
        subCategoryService.addSubCategory(subCategory.setCommonCategory(commonCategory));
 }
 @GetMapping("/allSubCategory")
    public List<SubCategory> allSubCategory(){
        return subCategoryService.findAllSubCategory();
 }

 ///////////////////////////////////////////////////////////////////////

    @PutMapping("/addManufacturer")
    public void addManufacturer(@RequestBody Manufacturer manufacturer){
        manufacturerService.addManufacturer(manufacturer);
    }
    @GetMapping("/allManufacturer")
    public List<Manufacturer> allManufacturer(){
        return manufacturerService.findAllManufacturer();
    }

//////////////////////////////////////////////////////////////////////////

@PutMapping("/addLot")
public void addLot(@RequestParam int id_Delivery, @RequestParam int id_Payment, @RequestParam int id_Product, @RequestBody Lot lot){
        Product product = productDao.findOne(id_Product);
        Delivery delivery = deliveryDao.findOne(id_Delivery);
        Payment payment = paymentDao.findOne(id_Payment);
        lotService.addLot(lot.setProduct(product).setDelivery(delivery).setPayment(payment));
}
@GetMapping("/allLot")
    public List<Lot> allLot(){
        return lotService.findAllLot();
}

///////////////////////////////////////////////////////////////////////////

    @PutMapping("/addPayment")
    public void addPayment(@RequestBody Payment payment){
        paymentService.addPayment(payment);
    }
    @GetMapping("/allPayment")
    public List<Payment> allPayment(){
        return paymentService.findAllPayment();
    }

 //////////////////////////////////////////////////////////////////////////

 @PutMapping("/addUser")
 public void addUser(@RequestBody User user){
        userService.addUser(user);
 }
 @GetMapping("/allUser")
    public List<User> allUser(){
        return userService.findAllUser();
 }
}
