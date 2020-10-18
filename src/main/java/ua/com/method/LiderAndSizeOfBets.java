package ua.com.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.entity.Bet;
import ua.com.service.bet.BetService;
import ua.com.service.user.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LiderAndSizeOfBets {
    @Autowired
    private BetService betService;
    @Autowired
    private UserService userService;

     public Map<String,String> Lider(int id_lot){
        List<Bet> listLotBet = betService.findAllBetByLot_id(id_lot);
         HashMap<String,String> map = new HashMap<>();
         int lotSize = listLotBet.size();
        if (lotSize >1){
            List<String> collect = listLotBet.stream()
                    .skip(lotSize - 1)
                    .map(bet -> userService.getUsernameFromBetById_Bet(bet.getId_Bet()))
                    .collect(Collectors.toList());
            String userLider = collect.get(0);
            map.put("userLider", userLider);
            map.put("countOfBet", String.valueOf(lotSize-1));
            return map;
        }else if (lotSize ==1){
            Optional<String> lider = listLotBet.stream()
                    .findFirst()
                    .map(bet -> userService.getUsernameFromBetById_Bet(bet.getId_Bet()));
            String userLider = lider.get();
            map.put("userLider", userLider);
            map.put("countOfBet", String.valueOf(lotSize));
            return map;
        }
        else{
            map.put("userLider", "Жодного");
            map.put("countOfBet", String.valueOf(lotSize-1));
            return map;
        }
    }


}
