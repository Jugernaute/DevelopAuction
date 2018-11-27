package ua.com.controllers.controllers_cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.entity.Basket;
import ua.com.entity.Lot;
import ua.com.entity.Product;
import ua.com.entity.User;
import ua.com.service.basket.BasketService;
import ua.com.service.lot.LotService;
import ua.com.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestControllerCart {

    @Autowired
    private UserService userService;
    @Autowired
    private LotService lotService;
    @Autowired
    private BasketService basketService;


    @GetMapping( "/allProductToCart" )
    public List<Product> allProductToCart() {
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        List<Lot> allLot = lotService.findAllLot();
        List<Product> productList = new ArrayList<>();
        for (Lot lot : allLot) {

            if (lot.getBasket() != null){

                if (user.getBasket().getIdBasket() == lot.getBasket().getIdBasket());
                Product product = lot.getProduct();
                productList.add(product);
            }
        }
        return productList;
    }
}