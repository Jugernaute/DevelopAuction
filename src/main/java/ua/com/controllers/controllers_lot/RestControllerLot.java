package ua.com.controllers.controllers_lot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
            Product product,
            ImageLink imageLink,
//            Lot lot,
            @RequestParam("uploadfile") MultipartFile [] uploadfile,
            @RequestParam String nameProduct,
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
            @RequestParam String methodDelivery

    ) {
//        System.out.println(nameProduct);
//        System.out.println(nameCommonCategory);
//        System.out.println(nameSubCategory);
//        System.out.println(stateProduct);

        String replace = dataStartLot.replace("T", " ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dataStart = LocalDateTime.parse(replace, formatter);
        System.out.println(dataStart);
        Lot lot= new Lot();

        lot.setDataStartLot(dataStart);



        // duration lot

            long durationLot = Long.parseLong(durationOfLot);
            // add int to date
        LocalDateTime dataEnd = dataStart.plusDays(durationLot);
        lot.setDataEndLot(dataEnd);
        System.out.println(dataEnd);
        lotService.addLot(lot);

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
        try {
            // Get the filename and build the local file path (be sure that the
            // application have write permissions on such directory)
//            List<ImageLink> linkList = new ArrayList<>();



            // Save the file locally
            for(MultipartFile file : uploadfile) {
                String filename = file.getOriginalFilename();
                String filepath = Paths.get(path, filename).toString();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(filepath)));
                stream.write(file.getBytes());
                stream.close();
            }

//            imageLink.setLinkOfImage(filename);
//            linkList.add(imageLink);
//            imageLink.setProduct(product);
//            productService.addProduct(product);
//            imageLinkService.save(imageLink);

//            System.out.println(product.getImageLinks());

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "file isnot upload";
        }
//        System.out.println(uploadfile.getOriginalFilename());
//        System.out.println(nameProduct);
        return "file is upload";

    }
}