package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

import java.util.List;

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
    public void addBet(@RequestBody Bet bet){
        betService.save(bet);
    }
    @GetMapping("/allBet")
    public List<Bet> allBet(){
        return betService.findAll();
    }
/////////////////////////////////////////////////////////////////////
@PutMapping("/addDelivery")
public void addDeliveryMethod(@RequestBody Delivery delivery){
    deliveryService.save(delivery);
}
    @GetMapping("/allDelivery")
    public List<Delivery> allDeliveryMethod(){
        return deliveryService.findAll();
    }

/////////////////////////////////////////////////////////////////
@PutMapping("/addProduct")
public void addProductMethod(@RequestBody Product product){
    productService.save(product);
}
    @GetMapping("/allProduct")
    public List<Product> allProductMethod(){
        return productService.findAll();
    }

////////////////////////////////////////////////////////////////////////
@PutMapping("/addCommonCategory")
public void addCommonCategory(@RequestBody CommonCategory commonCategory){
    commonCategoryService.save(commonCategory);
}
    @GetMapping("/allCommonCategory")
    public List<CommonCategory> allCommonCategory(){
        return commonCategoryService.findAll();
    }

 //////////////////////////////////////////////////////////////////////

 @PutMapping("/addSubCategory")
    public void addSubCategory(@RequestBody SubCategory subCategory){
        subCategoryService.save(subCategory);
 }
 @GetMapping("/allSubCategory")
    public List<SubCategory> allSubCategory(){
        return subCategoryService.findAll();
 }

 ///////////////////////////////////////////////////////////////////////

    @PutMapping("/addManufacturer")
    public void addManufacturer(@RequestBody Manufacturer manufacturer){
        manufacturerService.save(manufacturer);
    }
    @GetMapping("/allManufacturer")
    public List<Manufacturer> allManufacturer(){
        return manufacturerService.findAll();
    }

//////////////////////////////////////////////////////////////////////////

@PutMapping("/addLot")
public void addLot(@RequestBody Lot lot){
        lotService.save(lot);
}
@GetMapping("/allLot")
    public List<Lot> allLot(){
        return lotService.findAll();
}

///////////////////////////////////////////////////////////////////////////

    @PutMapping("/addPayment")
    public void addPayment(@RequestBody Payment payment){
        paymentService.save(payment);
    }
    @GetMapping("/allPayment")
    public List<Payment> allPayment(){
        return paymentService.findAll();
    }

 //////////////////////////////////////////////////////////////////////////

 @PutMapping("/addUser")
 public void addUser(@RequestBody User user){
        userService.save(user);
 }
 @GetMapping("/allUser")
    public List<User> allUser(){
        return userService.findAll();
 }
}
