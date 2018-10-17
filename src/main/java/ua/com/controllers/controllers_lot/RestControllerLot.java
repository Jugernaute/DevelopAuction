package ua.com.controllers.controllers_lot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.ImageLinkDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.*;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.delivery.DeliveryService;
import ua.com.service.imageLink.ImageLinkService;
import ua.com.service.lot.LotService;
import ua.com.service.manufacturer.ManufacturerService;
import ua.com.service.product.ProductService;
import ua.com.service.subcategory.SubСategoryService;
import ua.com.service.user.UserService;

import javax.mail.Multipart;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class RestControllerLot {
    @Autowired
    private CommonCategoryDao commonCategoryDao;
    @Autowired
    private SubCategoryDao subCategoryDao;
    @Autowired
    private SubСategoryService subСategoryService;
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



    @GetMapping("loadCommonCategory")
    public List loadCommonCategory (){
        return commonCategoryDao.findAll();
    }

    @PostMapping("loadSubCategory")
    public List loadSubCategory (/*CommonCategory commonCategory,*/
            @RequestBody String nameCommonCategory ){
        CommonCategory commonCategory = commonCategoryService.findByNameCommonCategory(nameCommonCategory);
        List<SubCategory> subCategoryList = commonCategory.getSubCategoryList();

        return subCategoryList;
    }

    @PostMapping("loadManufacturers")
    public List loadManufacturers (/*CommonCategory commonCategory,*/
            @RequestBody String nameManufacturer ){
        List<Manufacturer> all = manufacturerService.findAllManufacturer();
        System.out.println(all);
        return all;
    }

    @GetMapping("selectDeliveryList")
    public List list(){
        List<Delivery> all = deliveryService.findAllDelivery();
        return all;
    }

    @PutMapping("loadStateProduct")
    private List enumProduct(){
        List list = Arrays.asList(StateProduct.values());
//        System.out.println(list);
        return list;
    }


    @PostMapping("loadImg")
    public String uploadFile(
//            Delivery delivery,
//            User user,
//            Product product,
//            ImageLink imageLink,
//            Lot lot,
            @RequestParam("uploadfile") MultipartFile [] uploadfile,
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
            @RequestParam String methodDelivery []

    ) {

        Product product = new Product();
//        Delivery delivery = new Delivery();
        Manufacturer manufacturer = new Manufacturer();


        System.out.println(nameProduct);
        System.out.println(manufacturerProduct);
        System.out.println(nameCommonCategory);
        System.out.println(nameSubCategory);
        System.out.println(stateProduct);
        System.out.println(descriptionProduct);
        System.out.println(modelProduct);
        System.out.println(typeSell);
        System.out.println(hotPrice);
        System.out.println(startPrice);
        System.out.println(dataStartLot);
        System.out.println(durationOfLot);
        System.out.println(Arrays.toString(methodDelivery));



        /*
        *  start working with product object
        *
        *  */
        try{
            /*
             * for tree load link
             * */

            SubCategory byNameSubCategory = subСategoryService.findByNameSubCategory(nameSubCategory);
            product.setSubCategory(byNameSubCategory);

        }catch(Exception e){
            return "error in tree load link -> " +e.getMessage();
        }

        /*find user from session*/

        User userFind = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        product.setUserOwner(userFind);

        Manufacturer byNameManufacturer = manufacturerService.findByNameManufacturer(manufacturerProduct);
        product.setManufacturer(byNameManufacturer);

//        productService.addProduct(product);
        try{

            product.setNameProduct(nameProduct);

            if(modelProduct!=null){
                product.setModelProduct(modelProduct);
            }else{
                product.setModelProduct("Не заповнено користувачем");
            }

            product.setDescriptionProduct(descriptionProduct);

            StateProduct[] values = StateProduct.values();    //enum stateProduct
            for (StateProduct value : values) {
                String s= String.valueOf(value);
                if(s.equals(stateProduct.toUpperCase())) {
                    product.setStateProduct(value);
                }
        }

            TypeSell[] typeSells = TypeSell.values();       //enum typeOfSale
            for (TypeSell sell : typeSells) {
                if(sell.getString().equals(typeSell)){
                    product.setTypeSell(sell);
                }
            }
        } catch (Exception e){
            return "error with create product class -> "+e.getMessage();
        }
        productService.addProduct(product);
                            // working with multipart file
                            // Get the filename and build the local file path
        try{
            System.out.println(product.getTypeSell()+ " type sell");
            System.out.println(product.getNameProduct()+ " name prod");
            System.out.println(product.getUserOwner().getUsername()+ " user");
            System.out.println(product.getSubCategory()+ " subCateg");
            System.out.println(product.getManufacturer()+ " manuf");

        } catch (Exception e){
            return "error with product save -> " + e.getMessage();
        }

        try{
            String path = System.getProperty("user.home")
                    +File.separator
                    +"IdeaProjects"
                    +File.separator
                    +"DevelopAuction1"
                    +File.separator
                    +"src"
                    +File.separator
                    +"main"
                    +File.separator
                    +"webapp"
                    +File.separator
                    +"views"
                    +File.separator
                    +"img"
                    +File.separator
                    +"product_Img";
            try{

                for(MultipartFile file : uploadfile) {
                    ImageLink link =new ImageLink();
                    System.out.println(file.getOriginalFilename() + " file");
                    String filename = file.getOriginalFilename();
                    String filepath = Paths.get(path, filename).toString();
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(new File(filepath)));
                    link.setLinkOfImage(filename);
                    link.setProduct(product);
                    imageLinkService.addImageLink(link);                      // Save the file locally
                    stream.write(file.getBytes());
                    stream.close();
                }

               } catch (Exception e){
                return "error with imageLink save -> " + e.getMessage();
            }
        } catch (Exception e){
            return "error in filePath -> " + e.getMessage();
        }



        try{
            /*
            * Working with Lot object*/

            String replace = dataStartLot.replace("T", " ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dataStart = LocalDateTime.parse(replace, formatter);
                                                // duration lot
            long durationLot = Long.parseLong(durationOfLot);
            // add int to date
            LocalDateTime dataEnd = dataStart.plusDays(durationLot);

            //            working with delivery

            Lot lot = new Lot();
            for (String s : methodDelivery) {
                Delivery delivery = new Delivery();
                lot.setDataStartLot(dataStart);
                lot.setProduct(product);
                lot.setDataEndLot(dataEnd);
                lot.setStartPrice(Integer.parseInt(startPrice));
                if(hotPrice.equals("null")){
                    System.out.println(hotPrice + " hotPrice1");
//                lot.setHotPrice(Integer.parseInt(hotPrice));
                }else {
                    System.out.println(hotPrice + " hotPrice2");
                    lot.setHotPrice(Integer.parseInt(hotPrice));
                }

                Delivery byMethodDelivery = deliveryService.findByMethodDelivery(s);
                System.out.println(byMethodDelivery + " byMethodDelivery");
                lotService.addLot(lot);
//                delivery.setLot(lot);
                delivery.setMethodDelivery(s);
                delivery.setLot(lot);
                deliveryService.updateDelivery(delivery);
            }

          /*
          * end Lot object*/
        }catch (Exception e){
            return "error with Lot object -> " + e.getMessage();
        }

        /*
        * working with delivery
        * */


        userFind.setTypeOfUser(Collections.singleton(TypeUser.SELLER));
        userService.addUser(userFind);

        return "file is upload";

    }
}