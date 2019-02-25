package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.dao.*;
//import ua.com.dao.ProductDao;
import ua.com.entity.*;
import ua.com.service.delivery.DeliveryService;
import ua.com.service.user.UserService;

@Controller
public class MainControllerTest {

    @Autowired
    SubCategoryDao subCategoryDao;
    @Autowired
    CommonCategoryDao commonCategoryDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    ManufacturerDao manufacturerDao;
    @Autowired
    LotDao lotDao;
    @Autowired
    BetDao betDao;
    @Autowired
    UserDao userDao;
    @Autowired
    DeliveryDao deliveryDao;
    @Autowired
    PaymentDao paymentDao;
    @Autowired
    private UserService userService;
    @Autowired
    private DeliveryService deliveryService;


    @PostMapping("/saveCommonCategory")
    public String commonCategoryCreate(@RequestParam String nameCommonCategory) {
        CommonCategory commonCategory = new CommonCategory(nameCommonCategory);
        System.out.println(nameCommonCategory);
        System.out.println(commonCategory.getNameCommonCategory());
        commonCategoryDao.save(commonCategory);

        return "qwe";
    }

//    @GetMapping("/commonCategoryView")
//    public String commonCategory(Model model) {
//        List<CommonCategory> commonCategoryList = commonCategoryDao.findAll();
//        model.addAttribute("commonCategoryList", commonCategoryList);
//       return "home1";
//   }


//    @GetMapping("/home1")
//    public String comCatList(Model model) {
//        List<CommonCategory> commonCategoryList = commonCategoryDao.findAll();
//        model.addAttribute("commonCategoryList", commonCategoryList);
//        return "home1";
//    }

    @PostMapping("/saveSubCategory")
    public String subCategoryCreate(@RequestParam String nameSubCategory,
                                    @RequestParam int id_CommonCategory) {
        CommonCategory commonCategory = commonCategoryDao.findOne(id_CommonCategory);
        SubCategory subCategory = new SubCategory(nameSubCategory);
        subCategory.setCommonCategory(commonCategory);
        subCategoryDao.save(subCategory);
        return "qwe";
    }

    @PostMapping("/saveManufacturer")
    public String createManufacturer(@RequestParam String nameManufacturer) {
        Manufacturer manufacturer = new Manufacturer(nameManufacturer);
        manufacturerDao.save(manufacturer);
        return "qwe";
    }

    @PostMapping("/saveAdmin")
    public String saveAdmin (@RequestParam String username,
                             @RequestParam String password
                             ) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(Role.ROLE_ADMIN);
        userService.addUser(user);
        return "qwe";
    }


    @PostMapping("/saveUser1")
    public String createUser(@RequestParam String username,
                             @RequestParam int userBalance) {
        User user = new User(username, userBalance);
        userService.addUser(user);
        return "qwe";
    }


//    @PostMapping("/saveProduct")
//    public String createProduct(@RequestParam String nameProduct,
//                                @RequestParam String modelProduct,
//                                @RequestParam String descriptionProduct,
//                                @RequestParam int id_SubCategory,
//                                @RequestParam int id_Manufacturer,
//                                @RequestParam int id_User) {
//        SubCategory subCategory = subCategoryDao.findOne(id_SubCategory);
//        Manufacturer manufacturer = manufacturerDao.findOne(id_Manufacturer);
//        User user = userDao.findOne(id_User);
//        Product product = new Product(nameProduct, modelProduct,
//                descriptionProduct, subCategory, user, manufacturer, lot);
//        productDao.save(product);
//
//        return "qwe";
//    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int idProduct) {
        productDao.delete(idProduct);
        return "home1";
    }


    @PostMapping("/createDelivery")
    public String createDelivery(@RequestParam String methodDelivery) {
        Delivery delivery = new Delivery(methodDelivery);
        deliveryService.addDelivery(delivery);
        return "qwe";
    }

    @PostMapping("/createPayment")
    public String createPayment(@RequestParam String methodPayment) {
        Payment payment = new Payment(methodPayment);
        paymentDao.save(payment);
        return "qwe";
    }

//    @PostMapping("/createLot")
//    public String createAction(@RequestParam String dataStartLot,
//                               @RequestParam String dataEndLot,
//                               @RequestParam int id_Product,
//                               @RequestParam int startPrice,
//                               @RequestParam int hotPrice,
//                               @RequestParam int idDelivery,
//                               @RequestParam int idPayment) {
//        Product product = productDao.findOne(id_Product);
//        Delivery delivery = deliveryDao.findOne(idDelivery);
//        Payment payment = paymentDao.findOne(idPayment);
//        Lot lot = new Lot(dataStartLot, dataEndLot, startPrice, hotPrice);
//        lot.setDelivery(delivery);
//        lot.setPayment(payment);
//        lot.setProduct(product);
//        lotDao.save(lot);
//        return "home1";
//    }

    @GetMapping("/deleteLot")
    public String deleteLot(@RequestParam int idLot) {
        lotDao.delete(idLot);
        return "qwe";
    }

//    @PostMapping("/createBet")
//    public String createBet(@RequestParam int sum_of_the_bet,
//                            @RequestParam int id_Lot,
//                            @RequestParam int id_User) {
//        Bet bet = new Bet(sum_of_the_bet);
//        Lot lot = lotDao.getOne(id_Lot);
//        User user = userDao.getOne(id_User);
//        bet.setUser(user);
//        bet.setLot(lot);
//        betDao.save(bet);
//        return "home1";
//
//    }

    @GetMapping("/deleteBet")
    public String deleteBet(@RequestParam int idBet) {
        betDao.delete(idBet);
        return "home1";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam int idUser) {
        userDao.delete(idUser);
        return "home1";
    }




}



