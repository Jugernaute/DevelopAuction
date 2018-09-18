package ua.com.controllers.controllers_lot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.ManufacturerDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.CommonCategory;
import ua.com.entity.Manufacturer;
import ua.com.entity.SubCategory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestControllerLot {
    @Autowired
    private CommonCategoryDao commonCategoryDao;
    @Autowired
    private SubCategoryDao subCategoryDao;
    @Autowired
    private ManufacturerDao manufacturerDao;


    @GetMapping("upBD")
    public Map<String, List> upBD (){

        List<CommonCategory> commonCategoryDaoAll = commonCategoryDao.findAll();
        List<SubCategory> categoryDaoAll = subCategoryDao.findAll();
        List<Manufacturer> manufacturerDaoAll = manufacturerDao.findAll();
        Map<String, List>listMap = new LinkedHashMap<>();
        listMap.put("commonCategory",commonCategoryDaoAll);
        listMap.put("subCategory", categoryDaoAll);
        listMap.put("manufacturer", manufacturerDaoAll);
        System.out.println(listMap);
        return listMap;
    }
}
