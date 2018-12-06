package ua.com.controllers.controllers_createLot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.*;
import ua.com.service.bet.BetService;
import ua.com.service.commonCategory.CommonCategoryService;
import ua.com.service.delivery.DeliveryService;
import ua.com.service.imageLink.ImageLinkService;
import ua.com.service.locationLot.LocationLotService;
import ua.com.service.lot.LotService;
import ua.com.service.manufacturer.ManufacturerService;
import ua.com.service.product.ProductService;
import ua.com.service.subCategory.SubCategoryService;
import ua.com.service.user.UserService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class RestControllerCreateLot {
    @Autowired
    private CommonCategoryDao commonCategoryDao;
    @Autowired
    private SubCategoryDao subCategoryDao;
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    CommonCategoryService commonCategoryService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private ImageLinkService imageLinkService;
    @Autowired
    private ProductService productService;
    @Autowired
    private LotService lotService;
    @Autowired
    private UserService userService;
    @Autowired
    private LocationLotService locationLotService;
    @Autowired
    private BetService betService;

    @PostMapping("upload")
    private String upload(@RequestParam("fileload") MultipartFile[] uploadfile){
        for (MultipartFile multipartFile : uploadfile) {
            System.out.println(">>>"+multipartFile.getOriginalFilename());
        }
        return "ok";
    }


    @GetMapping("loadCommonCategory")
    public List loadCommonCategory() {
        return commonCategoryDao.findAll();
    }

    @PostMapping("loadSubCategory")
    public List loadSubCategory(/*CommonCategory commonCategory,*/
            @RequestBody String nameCommonCategory) {
        CommonCategory commonCategory = commonCategoryService.findByNameCommonCategory(nameCommonCategory);
        return commonCategory.getSubCategoryList();
    }

    @PostMapping("loadManufacturers")
    public List loadManufacturers(/*CommonCategory commonCategory,*/
            @RequestBody String nameManufacturer) {
        List<Manufacturer> all = manufacturerService.findAllManufacturer();
        System.out.println(all);
        return all;
    }

    @GetMapping("selectDeliveryList")
    public List list() {
        return deliveryService.findAllDelivery();
    }

    @PutMapping("loadStateProduct")
    private List enumProduct() {
        return Arrays.asList(StateProduct.values());
    }


    @PostMapping("loadImg")
    public String uploadFile(
            @RequestParam("uploadfile") MultipartFile[] uploadfile,
            @RequestParam String nameProduct,
            @RequestParam String manufacturerProduct,
            @RequestParam String nameCommonCategory,
            @RequestParam String nameSubCategory,
            @RequestParam String stateProduct,
            @RequestParam String descriptionProduct,
            @RequestParam String modelProduct,
            @RequestParam String typeSell,
            @RequestParam String hotPrice,
            @RequestParam String startPrice,
            @RequestParam String dataStartLot,
            @RequestParam String durationOfLot,
            @RequestParam String regionLot,
            @RequestParam String placeLot,
            @RequestParam String methodDelivery[]

    ) {

        Product product = new Product();
//        Delivery delivery = new Delivery();
//        Manufacturer manufacturer = new Manufacturer();


//        System.out.println(nameProduct);
//        System.out.println(manufacturerProduct);
//        System.out.println(nameCommonCategory);
//        System.out.println(nameSubCategory);
//        System.out.println(stateProduct);
//        System.out.println(descriptionProduct);
//        System.out.println(modelProduct);
//        System.out.println(typeSell);
//        System.out.println(hotPrice);
//        System.out.println(startPrice);
//        System.out.println(dataStartLot);
//        System.out.println(durationOfLot);
//        System.out.println(Arrays.toString(methodDelivery));
//        System.out.println("-------"+placeLot);
//        System.out.println("-------"+regionLot);



        /*
         *  start working with product object
         *
         *  */
        try {
            /*
             * for tree load link
             * */

            SubCategory byNameSubCategory = subCategoryService.findByNameSubCategory(nameSubCategory);
            product.setSubCategory(byNameSubCategory);

        } catch (Exception e) {
            return "error in tree load link -> " + e.getMessage();
        }

        /*find user from session*/

        User userFind = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        product.setUserOwner(userFind);

        Manufacturer byNameManufacturer = manufacturerService.findByNameManufacturer(manufacturerProduct);
        product.setManufacturer(byNameManufacturer);

        try {

            product.setNameProduct(nameProduct);

            if (modelProduct != null) {
                product.setModelProduct(modelProduct);
            } else {
                product.setModelProduct("Не заповнено користувачем");
}

            product.setDescriptionProduct(descriptionProduct);

            StateProduct[] values = StateProduct.values();    //enum stateProduct
            for (StateProduct value : values) {
                String s = String.valueOf(value);
                if (s.equals(stateProduct.toUpperCase())) {
                    product.setStateProduct(value);
                }
            }

            TypeSell[] typeSells = TypeSell.values();       //enum typeOfSale
            for (TypeSell sell : typeSells) {
                if (sell.getString().equals(typeSell)) {
                    product.setTypeSell(sell);
                }
            }
        } catch (Exception e) {
            return "error with create product class -> " + e.getMessage();
        }

        // working with multipart file
        // Get the filename and build the local file path
//        try {
//            System.out.println(product.getTypeSell() + " type sell");
//            System.out.println(product.getNameProduct() + " name prod");
//            System.out.println(product.getUserOwner().getUsername() + " user");
//            System.out.println(product.getSubCategory() + " subCateg");
//            System.out.println(product.getManufacturer() + " manuf");
//        } catch (Exception e) {
////            return "error with product save -> " + e.getMessage()+ " "+e.getLocalizedMessage();
//        }
        LocationLot locationLot = new LocationLot(regionLot, placeLot);

        productService.addProduct(product);
        locationLot.setProducts(product);
        locationLotService.addLocationLot(locationLot);
//        locationLots.clear();

        try {
            String path ="E:\\DevelopAuction"
                    + File.separator
                    + "src"
                    + File.separator
                    + "main"
                    + File.separator
                    + "webapp"
                    + File.separator
                    + "views"
                    + File.separator
                    + "img"
                    + File.separator
                    + "product_Img";
            try {

                List<ImageLink> all = imageLinkService.findAll();
                int add=0;
                int countImg=0;
                for (MultipartFile file : uploadfile) {
                    ++countImg;
                   do {
                       String filename = file.getOriginalFilename();
                    for (ImageLink imageLink : all) {
                        String linkOfImage = imageLink.getLinkOfImage();
                        while (linkOfImage.equals(filename)){
                            String toString = Integer.toString(++add);
                            filename = imageLink.getId_ImageLink()+toString+ filename ;
                        }
                    }
                    String filepath = Paths.get(path, filename).toString();
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(new File(filepath)));
                    ImageLink link = new ImageLink(filename);
                    link.setProduct(product);
                    imageLinkService.addImageLink(link);                      // Save the file locally
                    stream.write(file.getBytes());
                    stream.close();
//                       System.out.println("==> countcountImg "+countImg);
                   }while (countImg>uploadfile.length);                                    // only 4 img
                }
            } catch (Exception e) {
                return "error with imageLink save -> " + e.getMessage();
            }
        } catch (Exception e) {
            return "error in filePath -> " + e.getMessage();
        }
        Lot lot = new Lot();

        /*
         * Working with Lot object*/

        String replace = dataStartLot.replace("T", " ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dataStart = LocalDateTime.parse(replace, formatter);
        LocalDateTime dateTimeNow = LocalDateTime.now();
        // duration lot
        long durationLot = Long.parseLong(durationOfLot);
        // add int to date
        LocalDateTime dataEnd = dataStart.plusDays(durationLot);

        //            working with delivery


        if (dataStart.isBefore(dateTimeNow)) {
            return "enter dataTime right!!!";
        } else {
            lot.setDataStartLot(dataStart);
        }

        lot.setProduct(product);
        lot.setDataEndLot(dataEnd);
        Bet bet = new Bet();
        int price = Integer.parseInt(startPrice);
        float stepBet;
        if(price<=10){
            stepBet = 1;
            bet.setStepBet((int) stepBet);
        }else{
            stepBet = price*10/100;
            bet.setStepBet(Math.round(stepBet));
        }
        lot.setCurrentPrice(price);
        lot.setStartPrice(price);
        bet.setUser(userFind);
        bet.setLot(lot);


        if (hotPrice.equals("null")) {
            System.out.println(hotPrice + " hotPrice1");
//                lot.setHotPrice(Integer.parseInt(hotPrice));
        } else {
            System.out.println(hotPrice + " hotPrice2");
            lot.setHotPrice(Integer.parseInt(hotPrice));
        }
       //set & save stepBet from startPrice
//        List<Delivery> deliveryList = new ArrayList<>();
//        for (String method : methodDelivery) {
//            Delivery byMethodDelivery = deliveryService.findByMethodDelivery(method);
//            deliveryList.add(byMethodDelivery);
//            System.out.println(lot);
//            //byMethodDelivery.setLot(Collections.singletonList(lot));
//
////                System.out.println(byMethodDelivery.getLot()+"getLot");
////                System.out.println(byMethodDelivery+ "method");
////                System.out.println(lotByID + "lotID");
//        }
//        System.out.println(deliveryList);
//        lot.setDelivery(deliveryList);


//        lot.setDelivery(deliveryList);
//        lotService.addLot(lot);
//        for (Delivery delivery1 : deliveryList) {
//            delivery1.getLot().add(lotService.getLotById(lot.getId_Lot()));
//            deliveryService.addDelivery(delivery1);
//        }
//        System.out.println("------" +lot.getDelivery());

        //lotService.getLotById(lot.getId_Lot());
        // System.out.println(deliveryList + "delList");
//        System.out.println(lot + "lotId");
        // deliveryService.addDeliveries(deliveryList);
        //deliveryList.clear();
        lotService.addLot(lot);
        betService.addBet(bet);

        /*
         * end Lot object*/
//        }catch (Exception e){
//            return "error with Lot object -> " + e.getMessage();
//        }

        /*
         * working with delivery
         * */


        userFind.setTypeOfUser(Collections.singleton(TypeUser.SELLER));
        userService.addUser(userFind);

        return "file is upload";

    }
}