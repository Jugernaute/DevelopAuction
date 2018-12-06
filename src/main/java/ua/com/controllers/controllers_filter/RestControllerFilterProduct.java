package ua.com.controllers.controllers_filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.com.entity.CommonCategory;
import ua.com.entity.ImageLink;
import ua.com.entity.Product;
import ua.com.entity.SubCategory;
import ua.com.method.FillFilter_CommonCategory_OnRegisterUserPage;
import ua.com.method.FillFilter_SubCategory_OnRegisterUserPage;
import ua.com.method.LoadAllLotOnMainPage;
import ua.com.method.LoadAllLotOnPageUsingRest;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.product.ProductService;
import ua.com.service.subcategory.SubCategoryService;

import java.util.*;

@RestController
public class RestControllerFilterProduct {
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
        for (Map<Integer, Map<String, String>> next : set) {
            System.out.println(next);
            System.out.println("--------------------");
        }
        /*return on filterProductHomeRegisterUser.js*/
        return mapMap;
    }
}
