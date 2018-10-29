package ua.com.controllers.controllers_bet;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.entity.Bet;

@RestController
public class RestControllerBet {

    @PutMapping("lot/betUp")
    private String timeLoad(Bet bet,
            @RequestBody String sum_of_the_bet){

        System.out.println(bet.getSum_of_the_bet());
        System.out.println(sum_of_the_bet);
        return "ok";
    }
}
