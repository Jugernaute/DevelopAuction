package ua.com.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ua.com.entity.Lot;
import ua.com.entity.User;
import ua.com.service.lot.LotService;
import ua.com.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoadLotToCart {
    @Autowired
    private UserService userService;

    @Autowired
    private LotService lotService;

    public List<Lot> allLotToCart() {
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        List<Lot> allLot = lotService.findAllLot();
        List<Lot> lotList = new ArrayList<>();
        for (Lot lot : allLot) {

            if (lot.getBasket() != null){

                if (user.getBasket().getIdBasket() == lot.getBasket().getIdBasket());
                lotList.add(lot);
            }
        }
        return lotList;
    }
}
