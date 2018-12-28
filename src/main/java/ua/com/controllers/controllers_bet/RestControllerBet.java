package ua.com.controllers.controllers_bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ua.com.dao.UserDao;
import ua.com.entity.*;
import ua.com.method.LiderAndSizeOfBets;
import ua.com.service.basket.BasketService;
import ua.com.service.bet.BetService;
import ua.com.service.imageLink.ImageLinkService;
import ua.com.service.lot.LotService;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class  RestControllerBet {
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
    private BasketService basketService;
    @Autowired
    private LiderAndSizeOfBets liderAndSizeOfBets;

    @PostMapping("lot/betUp")
    private Map<String,String> betUp(
                            @RequestParam String betUps,
                            @RequestParam String idProductSession){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        String name = user.getUsername();
        int id_product = productService.getProductById(Integer.parseInt(idProductSession)).getId_Product();

        Lot lot = lotService.findLotByProduct_Id(id_product);
        int id_lot = lot.getId_Lot();
        Bet bet = new Bet();
        if (lot.getDataEndLot().isBefore(LocalDateTime.now())){
            map.put("endData","Аукціон по цьому товару вже закінчився");
             return map;
        }

        User createProductUser = userService.findUserByProductId(id_product);
        String userfromSession = SecurityContextHolder.getContext().getAuthentication().getName();

        User byUsername = userService.findByUsername(userfromSession);
        if (userfromSession.equals("anonymousUser") || !byUsername.isEnabled()){
            map.put("registration","Ви повинні спочатку авторизуватися");
            return map;
        }



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

    @GetMapping("/timerEnd")
    private void timeEnd(String idProductSession){
//        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        String name = user.getUsername();
        int id_product = productService.getProductById(Integer.parseInt(idProductSession)).getId_Product();

        Lot lot = lotService.findLotByProduct_Id(id_product);
        System.out.println("!!!!!!!!!!!!!11!!!!!!!!!!!" + lot);

        int id_lot = lot.getId_Lot();
        Bet bet = new Bet();
        List<Bet> allBetByLot_id = betService.findAllBetByLot_id(id_lot);
        bet = allBetByLot_id.get(allBetByLot_id.size()-1);

        int id_bet = bet.getId_Bet();
        User user1 = userService.getUserFromBetById_Bet(id_bet);

        if (user1.getBasket() != null){
            Basket basket = user1.getBasket();
            Lot lotByProduct_id = lotService.findLotByProduct_Id(id_product);
            lotService.addLot(lotByProduct_id.setBasket(basket));
            int currentPrice = lotByProduct_id.getCurrentPrice();

            lotService.addLot(lotByProduct_id);
            bet.setUser(user1);
            bet.setLot(lotByProduct_id);
            bet.setSum_of_the_bet(currentPrice);
            betService.addBet(bet);
        }else {
            Basket basket = new Basket();
            basketService.addBasket(basket.setUser(user1));

            Lot lotByProduct_id = lotService.findLotByProduct_Id(id_product);
            lotService.addLot(lotByProduct_id.setBasket(basket));
            int currentPrice = lotByProduct_id.getCurrentPrice();

            lotService.addLot(lotByProduct_id);
            bet.setUser(user1);
            bet.setLot(lotByProduct_id);
            bet.setSum_of_the_bet(currentPrice);
            betService.addBet(bet);
        }
    }

    @GetMapping("lot/lotDescription")
    private String description(@RequestParam String linkImg){
        int id_imageLink = imageLinkService.findByImageLink(linkImg).getId_ImageLink();
        String descriptionProduct = productService.findProductByImageLinks_Id(id_imageLink).getDescriptionProduct();
        return descriptionProduct.replace("\n", "<br>");
    }

    @GetMapping("lot/hotPrice")
    private String hotPrice(@RequestParam String linkImg) {
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        String name = user.getUsername();
        System.out.println("username1 : " + user.getUsername());
        Lot lotByImageLink_name = lotService.findLotByImageLink_Name(linkImg);
        int currentPrice = lotByImageLink_name.getCurrentPrice();

        if (user.getBasket() != null) {
            Basket basket = user.getBasket();

            lotService.addLot(lotByImageLink_name.setBasket(basket));
            if (lotByImageLink_name.getDataEndLot().isBefore(LocalDateTime.now())) {
                lotService.addLot(lotByImageLink_name);
                Bet bet = new Bet();
                bet.setUser(user);
                bet.setLot(lotByImageLink_name);
                bet.setSum_of_the_bet(currentPrice);
                betService.addBet(bet);
                return "Time is expired";
            }
            int hotPrice;
            if ((hotPrice = lotByImageLink_name.getHotPrice()) != 0 && !name.equals("anonymousUser")) {
                lotByImageLink_name.setCurrentPrice(hotPrice);
                lotService.addLot(lotByImageLink_name);

                Bet bet = new Bet();
                bet.setUser(user);
                bet.setLot(lotByImageLink_name);
                bet.setSum_of_the_bet(hotPrice);
                betService.addBet(bet);
                return "You buy product";
            }
            return "You must registration";
        } else {
            //створюєм корзину і закидуєм інформацію
            Basket basket = new Basket();
            basketService.addBasket(basket.setUser(user));
//            Lot lotByImageLink_name = lotService.findLotByImageLink_Name(linkImg);
            lotService.addLot(lotByImageLink_name.setBasket(basket));
            if (lotByImageLink_name.getDataEndLot().isBefore(LocalDateTime.now())) {
                lotService.addLot(lotByImageLink_name);
                Bet bet = new Bet();
                bet.setUser(user);
                bet.setLot(lotByImageLink_name);
                bet.setSum_of_the_bet(currentPrice);
                betService.addBet(bet);
                return "Time is expired";
            }
            int hotPrice;
            if ((hotPrice = lotByImageLink_name.getHotPrice()) != 0 && !name.equals("anonymousUser")) {
                lotByImageLink_name.setCurrentPrice(hotPrice);
                lotService.addLot(lotByImageLink_name);

                Bet bet = new Bet();
                bet.setUser(user);
                bet.setLot(lotByImageLink_name);
                bet.setSum_of_the_bet(hotPrice);
                betService.addBet(bet);
                return "You buy product";
            }
            return "You must registration";
        }
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
