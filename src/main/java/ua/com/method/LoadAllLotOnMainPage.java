package ua.com.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ua.com.entity.*;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.product.ProductService;
import ua.com.service.subcategory.SubCategoryService;
import ua.com.service.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoadAllLotOnMainPage {
    @Autowired
            private ProductService productService;
    @Autowired
    private CommonCategoryService commonCategoryService;
    @Autowired
    private SubCategoryService subCategoryService;

    public List<ImageLink> loadAllLotOnMainPage(){
        List<Product> allProduct = productService.findAllProduct();
        List<ImageLink> imgLink = new ArrayList<>();
                for (Product product : allProduct) {
            List<ImageLink> imageLinks = product.getImageLinks();
            if (!(imageLinks.size() == 0)){
                ImageLink imageLink = imageLinks.get(0);
                imgLink.add(imageLink);
            }
                }
        return imgLink;
    }

    public List<ImageLink> loadAllLotOnMainPage(String nameCommonCategory){
        CommonCategory byNameCommonCategory = commonCategoryService.findByNameCommonCategory(nameCommonCategory);
        List<SubCategory> subCategoryList = byNameCommonCategory.getSubCategoryList();
        List<List<Product>> collect = subCategoryList.stream()
                .map(SubCategory::getProducts)
                .filter(products -> products.size() > 0)
                .collect(Collectors.toList());
        List<ImageLink> imgLink = new ArrayList<>();
        for (List<Product> products : collect) {
            for (Product product : products) {
                List<ImageLink> imageLinks = product.getImageLinks();
                ImageLink imageLink = imageLinks.get(0);
                imgLink.add(imageLink);
            }
        }
        return imgLink;
    }

    public List<ImageLink> loadAllLotOnMainPage(SubCategory nameSubCategory){
        List<ImageLink> imgLink = new ArrayList<>();
        if (nameSubCategory.getProducts()!=null){
            List<Product> products = nameSubCategory.getProducts();
            for (Product product : products) {
                List<ImageLink> imageLinks = product.getImageLinks();
                ImageLink imageLink = imageLinks.get(0);
                imgLink.add(imageLink);
            }
        }

        return imgLink;
    }

//    public List<ImageLink> loadAllLotOnMainPage(String nameCommonCategory){
//        CommonCategory byNameCommonCategory = commonCategoryService.findByNameCommonCategory(nameCommonCategory);
//        List<SubCategory> subCategoryList = byNameCommonCategory.getSubCategoryList();
//        List<List<Product>> collect = subCategoryList.stream()
//                .map(SubCategory::getProducts)
//                .filter(products -> products.size() > 0)
//                .collect(Collectors.toList());
//        List<ImageLink> imgLink = new ArrayList<>();
//        for (List<Product> products : collect) {
//            for (Product product : products) {
//                List<ImageLink> imageLinks = product.getImageLinks();
//                ImageLink imageLink = imageLinks.get(0);
//                imgLink.add(imageLink);
//            }
//        }
//        return imgLink;
//    }
}
