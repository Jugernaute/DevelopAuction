package ua.com.controllers.controllers_bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ua.com.dao.UserDao;
import ua.com.entity.*;
import ua.com.service.bet.BetService;
import ua.com.service.imageLink.ImageLinkService;
import ua.com.service.lot.LotService;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class RestControllerBet {
    @Autowired
    private ImageLinkService imageLinkService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BetService betService;
    @Autowired
    private LotService lotService;
    @Autowired
    private UserService userService;

    @PostMapping("lot/betUp")
    private Map<String,String> betUp(
                            @RequestParam String betUps,
                            @RequestParam String srcLink){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
//        map.clear();

        ImageLink byImageLink = imageLinkService.findByImageLink(srcLink);
        int id_imageLink = byImageLink.getId_ImageLink();

        Product product = productService.findProductByImageLinks_Id(id_imageLink);

        int id_product = product.getId_Product();
        Lot lot = lotService.findLotByProduct_Id(id_product);
        int id_lot = lot.getId_Lot();

        User userOwner = userService.findUserByProductId(id_product);
        String thisUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User byUsername = userService.findByUsername(thisUser);

        if (thisUser.equals("anonymousUser") || !byUsername.isEnabled()){
            map.put("registration","Ви повинні спочатку авторизуватися");
            return map;
        }

        Bet bet = new Bet();

        int userBet=0;
        int currentPrice = lot.getCurrentPrice();
        int nextStepBet;

        if (betUps.equals("")){
            map.put("errorBet","зробіть ставку");
            return map;
        }

        try {
            userBet = Integer.parseInt(betUps);
        }catch(Exception e){
            map.put("errorBet","введіть число");
            return map;
        }

        if (userBet < (int) Math.round((currentPrice) * 0.1)+currentPrice){
            map.put("errorBet","введіть вищу ставку");
            return map;
        }
        currentPrice = userBet;

            lot.setCurrentPrice(currentPrice);
            lotService.addLot(lot);
            nextStepBet = (int) Math.round((currentPrice) * 0.1);
            bet.setStepBet(nextStepBet);
            bet.setLot(lot);
            bet.setSum_of_the_bet(currentPrice);
            bet.setUser(byUsername);
            betService.addBet(bet);

        List<Bet> listLotBet = betService.findAllBetByLot_id(id_lot);
        int betsLot = listLotBet.size();
//        System.out.println(">>>>"+betsLot);

        String username = userOwner.getUsername();
        int nextCurrentPrice;
        if(userBet<=10){
            nextCurrentPrice = userBet+1;
        }else
        {
            nextCurrentPrice=userBet+nextStepBet; //for output  placeholder
        }

        String price = Integer.toString(lot.getCurrentPrice());
        map.put("placeholder", String.valueOf(nextStepBet));
        map.put("price", price);
        map.put("nextCurrentPrice", String.valueOf(nextCurrentPrice));
        map.put("sizeLot", String.valueOf(betsLot));
        map.put("user", username);
        return map;
    }

    @GetMapping("lot/listBet")
    private Map<String,String> list (
            @RequestParam String linkOfImage){

        ImageLink byImageLink = imageLinkService.findByImageLink(linkOfImage);
        int id_imageLink = byImageLink.getId_ImageLink();

        Product product = productService.findProductByImageLinks_Id(id_imageLink);

        int id_product = product.getId_Product();
        Lot lot = lotService.findLotByProduct_Id(id_product);
        int id_lot = lot.getId_Lot();

//        List<Bet> listLotBet = betService.findAllBetByLot_id(id_lot);
        List<Object[]> objects = userService.listBetAndUserByLot_id(id_lot);

        Map<String, String> stringMap = new LinkedHashMap<>();

//        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        for (Object[] object : objects) {
//            map.add(object[17].toString(), object[14].toString());
            stringMap.put(object[17].toString(), object[14].toString());
//        System.out.println(" -> "+ object[14]+" <-> "+object[17]);
        }
        System.out.println(stringMap);
        return stringMap;
    }
}
