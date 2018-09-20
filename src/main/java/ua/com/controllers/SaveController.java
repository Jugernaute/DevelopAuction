//package ua.com.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ua.com.dao.*;
//import ua.com.entity.*;
//import ua.com.service.bet.BetService;
//import ua.com.service.commomCategory.CommonCategoryService;
//import ua.com.service.delivery.DeliveryService;
//import ua.com.service.lot.LotService;
//import ua.com.service.manufacturer.ManufacturerService;
//import ua.com.service.payment.PaymentService;
//import ua.com.service.product.ProductService;
//import ua.com.service.subcategory.SubСategoryService;
//import ua.com.service.user.UserService;
//
//import javax.annotation.PostConstruct;
//
//@Controller
//@RequestMapping("/save")
//public class SaveController {
//
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private BetService betService;
//    @Autowired
//    private CommonCategoryService commonCategoryService;
//    @Autowired
//    private DeliveryService deliveryService;
//    @Autowired
//    private LotService lotService;
//    @Autowired
//    private ManufacturerService manufacturerService;
//    @Autowired
//    private PaymentService paymentService;
//    @Autowired
//    private ProductService productService;
//    @Autowired
//    private SubСategoryService subCategoryService;
//
//    @Autowired
//    private LotDao lotDao;
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private DeliveryDao deliveryDao;
//    @Autowired
//    private PaymentDao paymentDao;
//    @Autowired
//    private ProductDao productDao;
//    @Autowired
//    private ManufacturerDao manufacturerDao;
//    @Autowired
//    private SubCategoryDao subCategoryDao;
//    @Autowired
//    private CommonCategoryDao commonCategoryDao;
//
//    @PostMapping("/user")
//    public String saveUser(User user){
//        userService.save(user);
//        return "save";
//    }
//
//    @PostMapping("/delete/user")
//    public String deleteUser(User user){
//        userService.deleteBuId(1);
//        return "delete";
//    }
//
//    @PostMapping("/bet")
//    public String saveBet(@RequestParam int idLot, @RequestParam int userId, Bet bet){
//        Lot lot = lotDao.findOne(idLot);
//        User user = userDao.findOne(userId);
//        betService.save(bet.setLot(lot).setUser(user));
//        return "save";
//    }
//
//
//
//    @PostMapping("/delivery")
//    public String saveDelivery(Delivery delivery){
//        deliveryService.save(delivery);
//        return "save";
//    }
//
//    @PostMapping("/lot")
//    public String saveLot(@RequestParam int idDelivery, @RequestParam int idPayment, @RequestParam int idProduct, Lot lot){
//        Delivery delivery = deliveryDao.findOne(idDelivery);
//        Payment payment = paymentDao.findOne(idPayment);
//        Product product = productDao.findOne(idProduct);
//        lotService.save(lot.setDelivery(delivery).setPayment(payment).setProduct(product));
//        return "save";
//    }
//
//    @PostMapping("/manufacturer")
//    public String saveManufacturer(Manufacturer manufacturer){
//        manufacturerService.save(manufacturer);
//        return "save";
//    }
//
//    @PostMapping("/payment")
//    public String savePayment(Payment payment){
//        paymentService.save(payment);
//        return "save";
//    }
//
//    @PostMapping("/product")
//    public String saveProduct(@RequestParam int idManufacturer, @RequestParam int idSubCategory, @RequestParam int userId, Product product){
//        Manufacturer manufacturer = manufacturerDao.findOne(idManufacturer);
//        SubCategory subCategory = subCategoryDao.findOne(idSubCategory);
//        User user = userDao.findOne(userId);
//        productService.save(product.setSubCategory(subCategory).setManufacturer(manufacturer).setUserOwner(user));
//        return "save";
//    }
//
//    @PostMapping("/commonCategory")
//    public String saveCommonCategory(CommonCategory commonCategory){
//        commonCategoryService.save(commonCategory);
//        return "save";
//    }
//
//    @PostMapping("/subCategory")
//    public String saveSubCategory(@RequestParam int idCommonCategory, SubCategory subCategory){
//        CommonCategory commonCategory = commonCategoryDao.findOne(idCommonCategory);
//        subCategoryService.save(subCategory.setCommonCategory(commonCategory));
//        return "save";
//    }
//    @ModelAttribute("userModel")
//    public User user(){
//        return new User();
//    }
//}
