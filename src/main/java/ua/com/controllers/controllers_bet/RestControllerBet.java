package ua.com.controllers.controllers_bet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.com.entity.*;
import ua.com.method.FindUserFromListOfBet;
import ua.com.method.LiderAndSizeOfBets;
import ua.com.method.error_log.Logs;
import ua.com.method.subscribers.BetLot;
import ua.com.method.subscribers.Subscribers;
import ua.com.service.bet.BetService;
import ua.com.service.imageLink.ImageLinkService;
import ua.com.service.lot.LotService;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@RestController
public class RestControllerBet {

    @Autowired
    private Logs logs;
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
    @Autowired
    private LiderAndSizeOfBets liderAndSizeOfBets;
    @Autowired
    private Subscribers subscribers;
    @Autowired
    private FindUserFromListOfBet findUserFromListOfBet;

    @PostMapping("lot/betUp")
    private Map<String,String> betUp(
                            @RequestParam String betUps,
                            @RequestParam String idProductSession) throws IOException {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        int id_product = productService.getProductById(Integer.parseInt(idProductSession)).getId_Product();

        Lot lot = lotService.findLotByProduct_Id(id_product);
        int id_lot = lot.getId_Lot();

        if (lot.getDataEndLot().isBefore(LocalDateTime.now())){
            map.put("endData","Аукціон по цьому товару вже закінчився");
            return map;
        }

        User createProductUser = userService.findUserByProductId(id_product);
        String userfromSession = SecurityContextHolder.getContext().getAuthentication().getName();
        User userFromSession = userService.findByUsername(userfromSession);

        if (userfromSession.equals("anonymousUser") || !userFromSession.isEnabled()){
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

/*
* subscribers method
* */
        List<User> userList = findUserFromListOfBet.userFromBet(id_lot, userfromSession);
        subscribers.userlist.clear();
        for (User user : userList) {
            subscribers.userlist.add(user);
            System.out.println(user.getUsername()+" "+ user.getEmail());
        }

        BetLot betLotMethod =new BetLot();
        betLotMethod.addObserved(subscribers);
        Product productById = productService.getProductById(id_product);
        String nameProduct = productById.getNameProduct();
        String modelProduct = productById.getModelProduct();
        try {
            betLotMethod.changeCurrentPrice(nameProduct, modelProduct, currentPrice);
        } catch (InterruptedException e) {
            logs.logError(e);
        }


        lotService.addLot(lot);
            nextStepBet = (int) Math.round((currentPrice) * 0.1);
            bet.setStepBet(nextStepBet);
            bet.setLot(lot);
            bet.setSum_of_the_bet(currentPrice);
            bet.setUser(userFromSession);
            betService.addBet(bet);



        List<Bet> listLotBet = betService.findAllBetByLot_id(id_lot);
        int betsLot = listLotBet.size();
//        System.out.println(">>>>"+betsLot);

        String userCreateProduct = createProductUser.getUsername();
        int nextCurrentPrice;
        if(userBet<=10){
            nextCurrentPrice = userBet+1;
        }else
        {
            nextCurrentPrice=userBet+nextStepBet; //for output  placeholder
        }

        String newCurrentPrice = Integer.toString(lot.getCurrentPrice());
//        map.put("placeholder", String.valueOf(nextStepBet));
        map.put("price", newCurrentPrice);
        map.put("nextCurrentPrice", String.valueOf(nextCurrentPrice));
        map.put("sizeLot", String.valueOf(betsLot));
        map.put("userFromSession", userfromSession);
        return map;
    }

    @GetMapping("lot/listBet")
    private Map<String,String> list (
            @RequestParam int idProduct){

//        int id_imageLink = imageLinkService.findByImageLink(linkOfImage).getId_ImageLink();
//
//        int id_product = productService.findProductByImageLinks_Id(id_imageLink).getId_Product();
        int id_product = productService.getProductById(idProduct).getId_Product();
        int id_lot = lotService.findLotByProduct_Id(id_product).getId_Lot();

        List<Object[]> objects = userService.listBetAndUserByLot_id(id_lot);

        Map<String, String> stringMap = new LinkedHashMap<>();

        for (Object[] object : objects) {
            /*
            * object[14] -> key; -> sumOfBet
            * object[17] -> value -> user equals sumOfBet
            * */
            stringMap.put(object[17].toString(), object[14].toString());
//        System.out.println(" -> "+ object[14]+" <-> "+object[17]);
        }
        stringMap.remove("0");
        return stringMap;
    }

    @GetMapping("lot/lotDescription")
    private String description(@RequestParam String linkImg){
        int id_imageLink = imageLinkService.findByImageLink(linkImg).getId_ImageLink();
        String descriptionProduct = productService.findProductByImageLinks_Id(id_imageLink).getDescriptionProduct();
        return descriptionProduct.replace("\n", "<br>");
    }

    @GetMapping("lot/hotPrice")
    private String hotPrice(@RequestParam String linkImg){

        Lot lotByImageLink_name = lotService.findLotByImageLink_Name(linkImg);

        if (lotByImageLink_name.getDataEndLot().isBefore(LocalDateTime.now())){
            return "Time is expired";
        }
        int hotPrice;
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        if ((hotPrice=lotByImageLink_name.getHotPrice())!=0 && !name.equals("anonymousUser")){
            lotByImageLink_name.setCurrentPrice(hotPrice);
            lotService.addLot(lotByImageLink_name);

            User user = userService.findByUsername(name);

            Bet bet = new Bet();
            bet.setUser(user);
            bet.setLot(lotByImageLink_name);
            bet.setSum_of_the_bet(hotPrice);
            betService.addBet(bet);
            return "You buy product";
        }
        return "You must registration";
    }

    @GetMapping("lot/updatePage")
    private Map updatePage(@RequestParam String idProduct){
        Product productById = productService.getProductById(Integer.parseInt(idProduct));
        Lot lotByProduct_id = lotService.findLotByProduct_Id(Integer.parseInt(idProduct));
        Map<String,String> map =new HashMap<>();
        int currentPrice = lotByProduct_id.getCurrentPrice();

        int nextCurrentPrice;
        int nextStepBet;
        nextStepBet = (int) Math.round((currentPrice) * 0.1);
        if(currentPrice<=10){
            nextCurrentPrice = currentPrice+1;
        }else
        {
            nextCurrentPrice=currentPrice+nextStepBet; //for output  placeholder
        }

        /*
         * Call from method directory
         * */
        Map<String, String> lider = liderAndSizeOfBets.Lider(lotByProduct_id.getId_Lot());
        Set<Map.Entry<String, String>> entries = lider.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            /*
             * return for key -> betsLot
             * return for key -> userLider*/
            map.put(entry.getKey(),entry.getValue());
        }

        map.put("price", String.valueOf(currentPrice));
        map.put("nextCurrentPrice", String.valueOf(nextCurrentPrice));
        return map;

    }
}
