package ua.com.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.entity.*;
import ua.com.method.abstracts.ListImageLinks;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.product.ProductService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoadAllLotOnMainPage extends ListImageLinks {
    @Autowired
            private ProductService productService;
    @Autowired
    private CommonCategoryService commonCategoryService;


    private List<Product> allProductList(){
        return productService.findAllProduct();
    }

    public List<ImageLink> loadAllLotOnMainPage(){
        List<Product> products = allProductList();
        return imageLinks(products);
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

    public List<ImageLink> loadAllLotOnMainPage(int option){
        /*
        for select on main page
       @option="0" Виберіть
       @option="1" Всі аукціони
       @option="2" Аукціони, що вже тривають
       @option="3" Завершені аукціони
       @option="4" Ще не розпочаті аукціони*/
        List<Product> products = allProductList();
        List<Product> productSortByData = new ArrayList<>();
        switch (option){
            case 1:
                return loadAllLotOnMainPage();
            case 2:
                for (Product product : products) {
                    if (product.getLot().getDataStartLot().isBefore(LocalDateTime.now()) &&
                            LocalDateTime.now().isBefore(product.getLot().getDataEndLot())){
                        productSortByData.add(product);
                    }
                }
                return imageLinks(productSortByData);
            case 3:
                for (Product product : products) {
                    if (product.getLot().getDataEndLot().isBefore(LocalDateTime.now())){
                        productSortByData.add(product);
                    }
                }
                return imageLinks(productSortByData);
            case 4:
                for (Product product : products) {
                    if (LocalDateTime.now().isBefore(product.getLot().getDataStartLot())){
                        productSortByData.add(product);
                    }
                }
                return imageLinks(productSortByData);
            case 0:
                return loadAllLotOnMainPage();
            default:
                return imageLinks(productSortByData);
        }
    }
}
