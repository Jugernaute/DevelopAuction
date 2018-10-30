package ua.com.controllers.controllers_bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.entity.Bet;
import ua.com.entity.ImageLink;
import ua.com.service.bet.BetService;
import ua.com.service.imageLink.ImageLinkService;
import ua.com.service.product.ProductService;

@RestController
public class RestControllerBet {
    @Autowired
    private ImageLinkService imageLinkService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BetService betService;

    @PostMapping("lot/betUp")
    private String timeLoad(
                            @RequestParam String betUps,
                            @RequestParam String srcLink){

        ImageLink byImageLink = imageLinkService.findByImageLink(srcLink);
        int id_lot = byImageLink.getProduct().getLot().getId_Lot();
        int userId = byImageLink.getProduct().getUserOwner().getUserId();
        int startPriceFromLot = byImageLink.getProduct().getLot().getStartPrice();
        Bet bet = new Bet();

        int stepBet = startPriceFromLot * 10 / 100;
//        Bet bet = new Bet(stepBet);
//        if (currentPrice > 0) {
//            currentPrice = currentPrice + stepBet;
//        } else if (currentPrice == 0) {
//            currentPrice = startPriceFromLot + currentPrice + stepBet;
//        }
//
//        bet.setStepBet(Integer.parseInt(betUps));
//
        System.out.println(betUps);
        System.out.println(srcLink);
        return "ok";
    }
}
