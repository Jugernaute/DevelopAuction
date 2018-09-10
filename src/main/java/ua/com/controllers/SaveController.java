package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private SubCategoryService subCategoryService;

    @PostMapping("/user")
    public String saveUser1(User user){
        userService.save(user);
        return "save";
    }

    @PostMapping("/bet")
    public String saveBet(Bet bet){
        betService.save(bet);
        return "save";
    }

    @PostMapping("/commonCategory")
    public String saveCommonCategory(CommonCategory commonCategory){
        commonCategoryService.save(commonCategory);
        return "save";
    }

    @PostMapping("/delivery")
    public String saveDelivery(Delivery delivery){
        deliveryService.save(delivery);
        return "save";
    }

    @PostMapping("/lot")
    public String saveLot(Lot lot){
        lotService.save(lot);
        return "save";
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
    public String saveProduct(Product product){
        productService.save(product);
        return "save";
    }

    @PostMapping("/sudCategory")
    public String saveSubCategory(SubCategory subCategory){
        System.out.println("sub");
        subCategoryService.save(subCategory);
        System.out.println("new sub");
        return "save";
    }
}
