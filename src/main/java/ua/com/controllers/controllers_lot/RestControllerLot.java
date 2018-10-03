package ua.com.controllers.controllers_lot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.*;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.delivery.DeliveryService;
import ua.com.service.fileStorage.FileStorage;
import ua.com.service.manufacturer.ManufacturerService;
import ua.com.service.subcategory.SubСategoryService;

import javax.mail.Multipart;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
    private FileStorage fileStorage;


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
        List<Manufacturer> all = manufacturerService.findAll();
        System.out.println(all);
        return all;
    }

    @GetMapping("selectDeliveryList")
    public List list(){
        List<Delivery> all = deliveryService.findAll();
        return all;
    }

    @PutMapping("loadStateProduct")
    private List enumProduct(){
        List list = Arrays.asList(StateProduct.values());
//        System.out.println(list);
        return list;
    }

    @PostMapping("loadImg")
    public String upload(@RequestParam("uploadfile") MultipartFile file) {
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
                +"img";

        /*
         * MultipartFile Upload
         */

            try {
                fileStorage.store(file);
                return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
            } catch (Exception e) {
                return "Error -> message = " + e.getMessage();
            }



        //do whatever you want with the MultipartFile
//        file.getInputStream();

    }
}