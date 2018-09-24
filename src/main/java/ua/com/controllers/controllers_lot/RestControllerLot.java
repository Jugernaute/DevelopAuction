package ua.com.controllers.controllers_lot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.*;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.delivery.DeliveryService;
import ua.com.service.manufacturer.ManufacturerService;
import ua.com.service.subcategory.SubСategoryService;

import javax.mail.Multipart;
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
    public void string(@RequestParam String formData){
        System.out.println(formData);
//        return formData;
    }
}
