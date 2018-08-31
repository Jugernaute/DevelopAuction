package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.ProductDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.CommonCategory;
import ua.com.entity.Product;
import ua.com.entity.SubCategory;


import java.util.List;

@Controller
public class MainController {

    @Autowired
    SubCategoryDao subCategoryDao;
    @Autowired
    CommonCategoryDao commonCategoryDao;
    @Autowired
    ProductDao productDao;


   @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/commonCategory")
    public  String common(Model model){
        List<CommonCategory> commonCategoryList = commonCategoryDao.findAll();
        model.addAttribute("common", commonCategoryList);
        return "list";
    }

    @GetMapping("/save")
    String xxx(){

        CommonCategory pobutova_tehnika = new CommonCategory("Pobutova tehnika");
        CommonCategory electronics= new CommonCategory("Electronics");
        CommonCategory telephonia= new CommonCategory("Telephonia");
        CommonCategory fototehcics= new CommonCategory("Fototehcics");

        SubCategory fotoaparatura = new SubCategory("fotoaparatura");
        SubCategory videoaparatura = new SubCategory("videoaparatura");
        SubCategory objectives = new SubCategory("objectives");
        SubCategory another = new SubCategory("another");

        Product product =new Product("fotoaparat","HP","new, very good",2000);
        Product product1 =new Product("videoaparatyra","HP","new, very good",2000);
        Product product2 =new Product("objective","HP","new, very good",2000);
        Product product3 =new Product("linza","HP","new, very good",2000);

        fotoaparatura.setCommonCategory(pobutova_tehnika);
        another.setCommonCategory(electronics);
        objectives.setCommonCategory(fototehcics);

        product.setSubCategory(fotoaparatura);
        product3.setSubCategory(another);
        product2.setSubCategory(objectives);
//        CommonCategory one1 = commonCategoryDao.findOne(1);
//        CommonCategory one2 = commonCategoryDao.findOne(2);
//        CommonCategory one3 = commonCategoryDao.findOne(3);
//        CommonCategory one4 = commonCategoryDao.findOne(4);
//
//        SubCategory sub1 = subCategoryDao.findOne(1);
//        SubCategory sub2 = subCategoryDao.findOne(2);
//        SubCategory sub3 = subCategoryDao.findOne(3);
//        SubCategory sub4 = subCategoryDao.findOne(4);


//        videoaparatura.setCommonCategory(electronics);
//
//        System.out.println(videoaparatura.getCommonCategory());
//
//        subCategoryDao.save(videoaparatura);


//        one2.setSubCategoryList(Collections.singletonList(sub1));
//        one3.setSubCategoryList(Collections.singletonList(sub4));
//        one4.setSubCategoryList(Collections.singletonList(sub3));
//        one1.setSubCategoryList(Collections.singletonList(sub2));

//        sub1.setProducts(Collections.singletonList(prod1));
//        sub2.setProducts(Collections.singletonList(prod4));
//        sub3.setProducts(Collections.singletonList(prod3));
//        sub4.setProducts(Collections.singletonList(prod2));

        commonCategoryDao.save(fototehcics);
        commonCategoryDao.save(telephonia);
        commonCategoryDao.save(electronics);
        commonCategoryDao.save(pobutova_tehnika);

        subCategoryDao.save(videoaparatura);
        subCategoryDao.save(fotoaparatura);
        subCategoryDao.save(objectives);
        subCategoryDao.save(another);

        productDao.save(product);
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

//        for (SubCategory subCategory : all) {
//            subCategory.setCommonCategory(one1);
//        }

        return "home";
    }

};
