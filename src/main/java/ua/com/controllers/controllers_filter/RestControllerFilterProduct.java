package ua.com.controllers.controllers_filter;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.com.entity.*;
import ua.com.method.FillFilter_CommonCategory_OnRegisterUserPage;
import ua.com.method.FillFilter_SubCategory_OnRegisterUserPage;
import ua.com.method.LoadAllLotOnMainPage;
import ua.com.method.LoadAllLotOnPageUsingRest;
import ua.com.method.filter.*;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.locationLot.LocationLotService;
import ua.com.service.product.ProductService;
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
    private ProductService productService;
    @Autowired
    private LocationLotService locationLotService;

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
        return mapMap;
        /*return on filterProductHomeRegisterUser.js*/
    }

//@Autowired
//ConditionService conditionService;


    @PostMapping(value = "/filter/criteria", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private String JsonCriteria(HttpServletRequest request) throws IOException {


            String s = IOUtils.toString(request.getInputStream(),"utf-8");
        System.out.println("json "+ s);
        SubCategory byNameSubCategory = subCategoryService.findByNameSubCategory("foto");
        System.out.println("---> " + byNameSubCategory);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = objectMapper.readValue(s, new TypeReference<List<Product>>(){});

        for (Product condition1 : products) {
            System.out.println("condition -> "+condition1.toString());
        }

//        List<Condition> conditions = objectMapper.readValue(s, new TypeReference<List<Condition>>() {
//        });

        Filter filter = new Filter();
        filter.addCondition(products);
        System.out.println("filter -> "+filter.toString());
        try{
            List all = productService.findAllBySpecification(filter);
            for (Object o : all) {
                System.out.println(o.toString());
            }
        }catch (Exception e){
            LOGGER.info(e.getMessage(),e);
        }
        return "ok";
    }
}
