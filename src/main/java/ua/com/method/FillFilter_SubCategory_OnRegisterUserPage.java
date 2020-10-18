package ua.com.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.entity.CommonCategory;
import ua.com.entity.Product;
import ua.com.entity.SubCategory;
import ua.com.service.commonCategory.CommonCategoryService;
import ua.com.service.sudcategory.SubCategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class FillFilter_SubCategory_OnRegisterUserPage {
    @Autowired
    private CommonCategoryService commonCategoryService;
    @Autowired
    private SubCategoryService subCategoryService;
    /*
    this method return list of all subCategory with their count of lot
    in every sub category
    for example:
    спорт(0)
    мода(2)
    * */
    public Map<String,String> fillFilterSubCategoryOnRegisterUserPage (String nameCommonCategory){

        Map<String,String > map = new HashMap<>();
        int count = 0;
        CommonCategory byNameCommonCategory = commonCategoryService.findByNameCommonCategory(nameCommonCategory);
        List<SubCategory> subCategoryList = byNameCommonCategory.getSubCategoryList();
                    for (SubCategory subCategory : subCategoryList) {
                        String nameSubCategory = subCategory.getNameSubCategory();
                        SubCategory byNameSubCategory = subCategoryService.findByNameSubCategory(nameSubCategory);
                        List<Product> products = subCategory.getProducts();
                for (Product product : products) {

                    if (product.getLot()!=null){
                        count++;
                    }
                }
                map.put(byNameSubCategory.getNameSubCategory(), String.valueOf(count));
                count=0;
            }
        return map;
    }
}
