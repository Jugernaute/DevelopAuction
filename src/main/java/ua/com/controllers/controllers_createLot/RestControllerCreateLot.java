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
import ua.com.service.sudcategory.SubCategoryService;
import ua.com.service.user.UserService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    private  CommonCategoryService commonCategoryService;
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

        try {
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

        LocationLot locationLot = new LocationLot(regionLot, placeLot);

        try {
        productService.addProduct(product);
        locationLot.setProducts(product);
        locationLotService.addLocationLot(locationLot);
        }catch(Exception e){
//            logs.logError(e);
        }

        try {
            String path = System.getProperty("user.home")
                    + File.separator
                    + "IdeaProjects"
                    + File.separator
                    + "DevelopAuction1"
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
        LocalDateTime dataEnd = dataStart.minusMinutes(durationLot);


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
        lotService.addLot(lot);
        betService.addBet(bet);       //set & save stepBet from startPrice

        userFind.setTypeOfUser(Collections.singleton(TypeUser.SELLER));
        userService.addUser(userFind);

        return "file is upload";

    }
}