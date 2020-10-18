package ua.com.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.entity.Bet;
import ua.com.entity.Lot;
import ua.com.entity.User;
import ua.com.service.bet.BetService;
import ua.com.service.lot.LotService;
import ua.com.service.user.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;


@Component
public class BascetAddLot {
    @Autowired
    private UserService userService;
    @Autowired
    private LotService lotService;
    @Autowired
    private BetService betService;


    public String allLotToCart(String linkImg, User user) {

        Lot lotByImageLink_name = lotService.findLotByImageLink_Name(linkImg);
        int currentPrice = lotByImageLink_name.getCurrentPrice();
        if (lotByImageLink_name.getDataEndLot().isBefore(LocalDateTime.now())) {
            lotService.addLot(lotByImageLink_name);
            Bet bet = new Bet();
            bet.setUser(user);
            bet.setLot(lotByImageLink_name);
            bet.setSum_of_the_bet(currentPrice);
            betService.addBet(bet);

        }
        return "Time is expired";
    }

    public String youBuyProduct(String linkImg, User user, String name){
        Lot lotByImageLink_name = lotService.findLotByImageLink_Name(linkImg);
        int hotPrice;
        if ((hotPrice = lotByImageLink_name.getHotPrice()) != 0 && !name.equals("anonymousUser")) {
            lotByImageLink_name.setCurrentPrice(hotPrice);
            lotService.addLot(lotByImageLink_name);

            Bet bet = new Bet();
            bet.setUser(user);
            bet.setLot(lotByImageLink_name);
            bet.setSum_of_the_bet(hotPrice);
            betService.addBet(bet);
        }
        return "You buy product";
    }
}
