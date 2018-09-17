package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.dao.*;
//import ua.com.dao.ProductDao;
import ua.com.entity.*;
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


    @PostMapping("/saveCommonCategory")
    public String commonCategoryCreate(@RequestParam String nameCommonCategory) {
        CommonCategory commonCategory = new CommonCategory(nameCommonCategory);
        commonCategoryDao.save(commonCategory);
        return "home1";
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
        return "home1";
    }

    @PostMapping("/saveManufacturer")
    public String createManufacturer(@RequestParam String nameManufacturer) {
        Manufacturer manufacturer = new Manufacturer(nameManufacturer);
        manufacturerDao.save(manufacturer);
        return "home1";
    }

    @PostMapping("/saveUser1")
    public String createUser(@RequestParam String username,
                             @RequestParam int userBalance) {
        User user = new User(username, userBalance);
        userService.save(user);
        return "home1";
    }


    @PostMapping("/saveProduct")
    public String createProduct(@RequestParam String nameProduct,
                                @RequestParam String modelProduct,
                                @RequestParam String descriptionProduct,
                                @RequestParam int id_SubCategory,
                                @RequestParam int id_Manufacturer,
                                @RequestParam int id_User) {
        SubCategory subCategory = subCategoryDao.findOne(id_SubCategory);
        Manufacturer manufacturer = manufacturerDao.findOne(id_Manufacturer);
        User user = userDao.findOne(id_User);
        Product product = new Product(nameProduct, modelProduct,
                descriptionProduct, subCategory, user, manufacturer);
        productDao.save(product);

        return "home1";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int idProduct) {
        productDao.delete(idProduct);
        return "home1";
    }


    @PostMapping("/createDelivery")
    public String createDelivery(@RequestParam String methodDelivery) {
        Delivery delivery = new Delivery(methodDelivery);
        deliveryDao.save(delivery);
        return "home1";
    }

    @PostMapping("/createPayment")
    public String createPayment(@RequestParam String methodPayment) {
        Payment payment = new Payment(methodPayment);
        paymentDao.save(payment);
        return "home1";
    }

    @PostMapping("/createLot")
    public String createAction(@RequestParam String dataStartLot,
                               @RequestParam String dataEndLot,
                               @RequestParam int id_Product,
                               @RequestParam int startPrice,
                               @RequestParam int hotPrice,
                               @RequestParam int idDelivery,
                               @RequestParam int idPayment) {
        Product product = productDao.findOne(id_Product);
        Delivery delivery = deliveryDao.findOne(idDelivery);
        Payment payment = paymentDao.findOne(idPayment);
        Lot lot = new Lot(dataStartLot, dataEndLot, startPrice, hotPrice);
        lot.setDelivery(delivery);
        lot.setPayment(payment);
        lot.setProduct(product);
        lotDao.save(lot);
        return "home1";
    }

    @GetMapping("/deleteLot")
    public String deleteLot(@RequestParam int idLot) {
        lotDao.delete(idLot);
        return "home1";
    }

    @PostMapping("/createBet")
    public String createBet(@RequestParam int sum_of_the_bet,
                            @RequestParam int id_Lot,
                            @RequestParam int id_User) {
        Bet bet = new Bet(sum_of_the_bet);
        Lot lot = lotDao.getOne(id_Lot);
        User user = userDao.getOne(id_User);
        bet.setUser(user);
        bet.setLot(lot);
        betDao.save(bet);
        return "home1";

    }

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



//    @PostMapping("/joinBuyerToAuction")
//    public String changeProduct(
//            @RequestParam int id_Client,
//            @RequestParam int id_Auction) {
//        Lot lot = auctionDao.findOne(id_Auction);
//        Client client = clientDao.findOne(id_Client);
//        boolean add1 = lot.getByersList().add(client);
//        if (add1) {
//            auctionDao.save(lot);
//        } else System.out.println("error1");
//        boolean add = client.getLotList().add(lot);
//        if (add) {
//            clientDao.save(client);
//        } else System.out.println("error");
//        return "home1";
//    }

//   @GetMapping("/")
//    public String home(){
//        return "home";
//    }
//
//    @GetMapping("/save")
//    String xxx(){
//
//        CommonCategory pobutova_tehnika = new CommonCategory("Pobutova tehnika");
//        CommonCategory electronics= new CommonCategory("Electronics");
//        CommonCategory telephonia= new CommonCategory("Telephonia");
//        CommonCategory fototehcics= new CommonCategory("Fototehcics");
//
//        SubCategory fotoaparatura = new SubCategory("fotoaparatura");
//        SubCategory videoaparatura = new SubCategory("videoaparatura");
//        SubCategory objectives = new SubCategory("objectives");
//        SubCategory another = new SubCategory("another");
//
//        Product product =new Product("fotoaparat","HP","new, very good",2000);
//        Product product1 =new Product("videoaparatyra","HP","new, very good",2000);
//        Product product2 =new Product("objective","HP","new, very good",2000);
//        Product product3 =new Product("linza","HP","new, very good",2000);
//
//        fotoaparatura.setCommonCategory(pobutova_tehnika);
//        another.setCommonCategory(electronics);
//        objectives.setCommonCategory(fototehcics);
//
//        product.setSubCategory(fotoaparatura);
//        product3.setSubCategory(another);
//        product2.setSubCategory(objectives);
////        CommonCategory one1 = commonCategoryDao.findOne(1);
////        CommonCategory one2 = commonCategoryDao.findOne(2);
////        CommonCategory one3 = commonCategoryDao.findOne(3);
////        CommonCategory one4 = commonCategoryDao.findOne(4);
////
////        SubCategory sub1 = subCategoryDao.findOne(1);
////        SubCategory sub2 = subCategoryDao.findOne(2);
////        SubCategory sub3 = subCategoryDao.findOne(3);
////        SubCategory sub4 = subCategoryDao.findOne(4);
//
//
////        videoaparatura.setCommonCategory(electronics);
////
////        System.out.println(videoaparatura.getCommonCategory());
////
////        subCategoryDao.save(videoaparatura);
//
//
////        one2.setSubCategoryList(Collections.singletonList(sub1));
////        one3.setSubCategoryList(Collections.singletonList(sub4));
////        one4.setSubCategoryList(Collections.singletonList(sub3));
////        one1.setSubCategoryList(Collections.singletonList(sub2));
//
////        sub1.setProducts(Collections.singletonList(prod1));
////        sub2.setProducts(Collections.singletonList(prod4));
////        sub3.setProducts(Collections.singletonList(prod3));
////        sub4.setProducts(Collections.singletonList(prod2));
//
//        commonCategoryDao.save(fototehcics);
//        commonCategoryDao.save(telephonia);
//        commonCategoryDao.save(electronics);
//        commonCategoryDao.save(pobutova_tehnika);
//
//        subCategoryDao.save(videoaparatura);
//        subCategoryDao.save(fotoaparatura);
//        subCategoryDao.save(objectives);
//        subCategoryDao.save(another);
//
//        productDao.save(product);
//        productDao.save(product1);
//        productDao.save(product2);
//        productDao.save(product3);
//
////        for (SubCategory subCategory : all) {
////            subCategory.setCommonCategory(one1);
////        }
//
//        return "home";
}



