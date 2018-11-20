package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.dao.*;
import ua.com.entity.*;
import ua.com.service.basket.BasketService;
import ua.com.service.bet.BetService;
import ua.com.service.commonCategory.CommonCategoryService;
import ua.com.service.delivery.DeliveryService;
import ua.com.service.lot.LotService;
import ua.com.service.manufacturer.ManufacturerService;
import ua.com.service.payment.PaymentService;
import ua.com.service.product.ProductService;
import ua.com.service.subCategory.SubCategoryService;
import ua.com.service.user.UserService;
import java.util.Scanner;

import javax.naming.Context;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.io.File.separator;

@RestController
public class TestRestController {

    @Autowired
    private BasketService basketService;
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
    private BasketDao basketDao;
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
//        Basket basket = basketDao.findOne(idBasket);
        Manufacturer manufacturer = manufacturerDao.findOne(id_Manufacturer);
        SubCategory subCategory = subCategoryDao.findOne(id_SubCategory);
        User user = userService.getUserById(userId);
        productService.addProduct(product.setUserOwner(user).setSubCategory(subCategory).setManufacturer(manufacturer));
    }
    @GetMapping("/allProduct")
    public List<Product> allProductMethod(){
        System.out.println("aaaaa" + productService.findAllProduct());

        return productService.findAllProduct();

    }

    @GetMapping("/deleteProduct")
    public void deleteProduct(){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("asasa" + scan);
//        int number = scan.nextInt();
//        System.out.println(number);
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
    public void addLot(@RequestParam int id_Delivery,@RequestParam int id_Product, @RequestParam int id_Payment, @RequestBody Lot lot){
        Delivery delivery = deliveryDao.findOne(id_Delivery);
        Product product = productDao.findOne(id_Product);
        Payment payment = paymentDao.findOne(id_Payment);
        lotService.addLot(lot.setPayment(payment).setProduct(product).setDelivery(delivery));

    }
//створення і заповнення корзини
    @PostMapping("/setCartToLot")
    public void setCartToLot(){
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println("username1 : " + user.getUsername());

        if (user.getBasket() != null){
            System.out.println("записуєм інфу");

        }
        else {
            //створюєм корзину і закидуєм інформацію
            Basket basket = new Basket();
            basketService.addBasket(basket.setUser(user));
        }

    }

    @GetMapping("/updateLot")
    public void updateLot(@RequestParam int id_lot){
        lotService.getLot(id_lot);
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

    @GetMapping("/putUserInBasket")
    public List<User> putUserInBasket(){
        return userService.findAllUser();
    }


    //////////////////////////////////////////////////////////////////////////////

    @PutMapping("/addBasket")
    public void addBasket(@RequestBody Basket basket, @RequestParam int userId){
        User user = userDao.findOne(userId);
        System.out.println(basket);
        System.out.println(user);
        basketService.addBasket(basket.setUser(user));
    }

    //    @GetMapping("getBasket")
//    public Basket getBasket(Basket basket){
//        return basketService.getBasketById(5);
//    }
    @GetMapping("/nameProduct")
    public Product nameProduct(){


        Product productById = productService.getProductById(1);
        System.out.println("prod : " + productById);
//        final SubCategory subCategory = productById.getSubCategory();


        return productById;
    }

    @GetMapping("/goCart")
    public void info(){
//        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//
//        if (user != null){
//            System.out.println("user : " + user + user.getUsername());
//        }
//        else {System.out.println("11111111");}
    }
}


