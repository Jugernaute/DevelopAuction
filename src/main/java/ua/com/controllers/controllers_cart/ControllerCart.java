package ua.com.controllers.controllers_cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.entity.ImageLink;
import ua.com.entity.Lot;
import ua.com.entity.User;
import ua.com.method.LoadLotToCart;
import ua.com.service.lot.LotService;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerCart {

    @Autowired
    private UserService userService;
    @Autowired
    private LotService lotService;
    @Autowired
    private ProductService productService;
    @Autowired
    private LoadLotToCart loadLotToCart;

    @GetMapping( "/goToCart" )
    public String goToCart(Model model) {
        Map<User, Lot> userLot = new HashMap<>();

        String userSession = SecurityContextHolder.getContext().getAuthentication().getName();
        User username = userService.findByUsername(userSession);
        List<Lot> lots = loadLotToCart.allLotToCart();

        for (Lot lot : lots) {
            User userByProductId = userService.findUserByProductId(lot.getProduct().getId_Product());
            if (userSession.equals(lot.getBasket().getUser().getUsername())) {
                userLot.put(userByProductId, lot);
            }
        }

        model.addAttribute("infoProd", userLot);
        model.addAttribute("user", username);
        return "cart";
    }

    @GetMapping("/clearUpCart" )
    public String allLotToCart() {
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        List<Lot> allLot = lotService.findAllLot();
        for (Lot lot : allLot) {

            if (lot.getBasket() != null) {
                if (user.getBasket().getIdBasket() == lot.getBasket().getIdBasket()) {

                    int id_product = lot.getProduct().getId_Product();
                    int id_lot = lot.getId_Lot();
                    lotService.deleteLotById(id_lot);
                    productService.deleteProductById(id_product);

                }
            }

        }
        return "cart";
    }

}