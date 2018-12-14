package ua.com.controllers.controllers_filter;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.*;
import ua.com.method.FillFilter_CommonCategory_OnRegisterUserPage;
import ua.com.method.FillFilter_SubCategory_OnRegisterUserPage;
import ua.com.method.LoadAllLotOnMainPage;
import ua.com.method.LoadAllLotOnPageUsingRest;
import ua.com.method.filter.Comparison;
import ua.com.method.filter.Condition;
import ua.com.method.filter.Filter;
import ua.com.method.filter.Filter2;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.subcategory.SubCategoryService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;
import java.util.List;

@RestController
public class RestControllerFilterProduct {
    private static final Logger LOGGER = Logger.getLogger(RestControllerFilterProduct.class.getSimpleName());
    @Autowired
    private CommonCategoryService commonCategoryService;
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private LoadAllLotOnMainPage allLotOnMainPage;
    @Autowired
    private LoadAllLotOnPageUsingRest loadAllLotOnPageUsingRest;
    @Autowired
    private FillFilter_SubCategory_OnRegisterUserPage fillFilter_subCategory_onRegisterUserPage;
    @Autowired
    private FillFilter_CommonCategory_OnRegisterUserPage fillFilter_commonCategory_onRegisterUserPage;
    @Autowired
    private SubCategoryDao subCategoryDao;

    @GetMapping("filter/{nameCommProduct}")
    private Map filterByCommCategory(@PathVariable String nameCommProduct){
        List<ImageLink> linkList = allLotOnMainPage.loadAllLotOnMainPage(nameCommProduct);
        return loadAllLotOnPageUsingRest.loadAllLotOnPageUsingRest(linkList);
    }

    @GetMapping("filter/comm/{nameCommProduct}")
    private Set filterBySubCategory(@PathVariable String nameCommProduct){

        Set<Map<String,String>> maps = new LinkedHashSet<>();
        Map<String, String> subMap = fillFilter_subCategory_onRegisterUserPage.fillFilterSubCategoryOnRegisterUserPage(nameCommProduct);

        List<ImageLink> linkList = allLotOnMainPage.loadAllLotOnMainPage(nameCommProduct);
        Map<Integer, Map<String, String>> mapMap = loadAllLotOnPageUsingRest.loadAllLotOnPageUsingRest(linkList);
        /* map where
        key -> for examp >>> idProduct:
        value -> for example >>>>  1
        integer(key in map)>>>> every integer is new product, added to map
        for views on registration user page
        */
        maps.add(subMap); // first object always must have subMap
        Set<Map.Entry<Integer, Map<String, String>>> entries = mapMap.entrySet();
        for (Map.Entry<Integer, Map<String, String>> entry : entries) {
            maps.add(entry.getValue());
        }
        /*return on filterProductHomeRegisterUser.js*/
        return maps;
    }

    @GetMapping("filter/allLot")
    private Set allLot(){
        Set<Map<String,String>>mapSet = new LinkedHashSet<>();
        List<ImageLink> linkList = allLotOnMainPage.loadAllLotOnMainPage();
        Map<Integer, Map<String, String>> mapMap = loadAllLotOnPageUsingRest.loadAllLotOnPageUsingRest(linkList);
        /* map where
        key -> for examp >>> idProduct:
        value -> for example >>>>  1
        integer(key in map)>>>> every integer is new product, added to map
        for views on registration user page
        */
        List<CommonCategory> allCommonCategory = commonCategoryService.findAllCommonCategory();
        Map<String,String> map = fillFilter_commonCategory_onRegisterUserPage.fillFilterOnRegisterUserPage(allCommonCategory);

        mapSet.add(map);    // first object always must have subMap
        Set<Map.Entry<Integer, Map<String, String>>> entries = mapMap.entrySet();
        for (Map.Entry<Integer, Map<String, String>> entry : entries) {
            mapSet.add(entry.getValue());
        }
        /*return on filterProductHomeRegisterUser.js*/
        return mapSet;
    }

//    FilterSetContainer setContainer = new FilterSetContainer();
private Set<Map<Integer, Map<String, String>>> set = new LinkedHashSet<>();

    @GetMapping ("sub/{nameSubProduct}")
    private Map filterOnlySubProduct(@PathVariable String nameSubProduct){
        SubCategory subCategory = subCategoryService.findByNameSubCategory(nameSubProduct);
        List<ImageLink> linkList = allLotOnMainPage.loadAllLotOnMainPage(subCategory);
        Map<Integer, Map<String, String>> mapMap = loadAllLotOnPageUsingRest.loadAllLotOnPageUsingRest(linkList);

        set.add(mapMap);
//        for (Map<Integer, Map<String, String>> next : set) {
//            System.out.println(next);
//            System.out.println("--------------------");
//        }
        /*return on filterProductHomeRegisterUser.js*/
        return mapMap;
    }


    @PostMapping(value = "filter/criteria", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private String JsonCriteria(HttpServletRequest request) throws IOException {

//        try{
            String s = IOUtils.toString(request.getInputStream(),"utf-8");
            System.out.println(s);
            System.out.println("----------------");
            ObjectMapper objectMapper = new ObjectMapper();
        Condition condition = objectMapper.readValue(s, Condition.class);
        List<String> nameSubCategory = condition.nameSubCategory;
//        for (String s1 : nameSubCategory) {
//            subCategoryDao.findAll(Filter2.products(s1))
//                    .forEach(System.out::println);
//        }


        Filter filter = new Filter();
        filter.addCondition(condition);
        filter.addCondition((new Condition.Builder().setComparison().setNameSubCategory(nameSubCategory).build()));
        List<SubCategory> all = subCategoryDao.findAll(filter);
        for (SubCategory subCategory : all) {
            System.out.println(subCategory);
        }


//        }catch (Exception e){
//            LOGGER.error(e.getMessage(),e.fillInStackTrace());
//        }

        return "ok";
    }
}
