package ua.com.controllers.controllers_lot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.ManufacturerDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.CommonCategory;
import ua.com.entity.Manufacturer;
import ua.com.entity.SubCategory;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.manufacturer.ManufacturerService;
import ua.com.service.subcategory.SubcategoryService;

import java.util.List;

@RestController
public class RestControllerLot {
    @Autowired
    private CommonCategoryDao commonCategoryDao;
    @Autowired
    private SubCategoryDao subCategoryDao;
    @Autowired
    private SubcategoryService subcategoryService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    CommonCategoryService commonCategoryService;


    @GetMapping("loadCommonCategory")
    public List loadCommonCategory (){
        return commonCategoryDao.findAll();
    }

    @PostMapping("loadSubCategory")
    public List loadSubCategory (/*CommonCategory commonCategory,*/
            @RequestBody String nameCommonCategory ){
        CommonCategory commonCategory = commonCategoryService.findByNameCommonCategory(nameCommonCategory);
        List<SubCategory> subCategoryList = commonCategory.getSubCategoryList();
        System.out.println(nameCommonCategory);
        return subCategoryList;
    }

    @PostMapping("loadManufacturers")
    public List loadManufacturers (/*CommonCategory commonCategory,*/
            @RequestBody String nameManufacturer ){
        List<Manufacturer> all = manufacturerService.findAll();
        System.out.println(all);
        return all;
    }
}
