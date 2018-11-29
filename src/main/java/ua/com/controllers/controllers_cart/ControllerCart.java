package ua.com.controllers.controllers_cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.entity.Lot;
import ua.com.entity.User;
import ua.com.method.LoadLotToCart;
import ua.com.service.lot.LotService;
import ua.com.service.user.UserService;

import java.util.List;

@Controller
public class ControllerCart {

    @Autowired
    private UserService userService;
    @Autowired
    private LotService lotService;
    @Autowired
    private LoadLotToCart loadLotToCart;

    @GetMapping("/goToCart")
    public String goToCart(Model model) {
        String userSession = SecurityContextHolder.getContext().getAuthentication().getName();
        User username = userService.findByUsername(userSession);
        List<Lot> lots = loadLotToCart.allLotToCart();
        model.addAttribute("infoProd", lots);
        model.addAttribute("user", username);
        return "cart";
    }
}