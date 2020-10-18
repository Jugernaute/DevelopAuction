package ua.com.method;

import org.springframework.stereotype.Component;
import ua.com.entity.CommonCategory;
import ua.com.entity.Product;
import ua.com.entity.SubCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FillFilter_CommonCategory_OnRegisterUserPage {
/*
this method return list of all commonCategory with their count of lot
in every common category
for example:
спорт(0)
мода(2)
* */
    public Map<String,String> fillFilterOnRegisterUserPage (List<CommonCategory> allCommonCategory){

        Map<String,String> map = new HashMap<>();
        int count = 0;
                for (CommonCategory commonCategory : allCommonCategory) {
            String nameCommonCategory = commonCategory.getNameCommonCategory();
            List<SubCategory> subCategoryList = commonCategory.getSubCategoryList();
            for (SubCategory subCategory : subCategoryList) {
                List<Product> products = subCategory.getProducts();
                for (Product product : products) {
                    if (product.getLot()!=null){
                        count++;
                    }
                }
}
            map.put(nameCommonCategory, String.valueOf(count));
            count=0;
        }
        return map;
    }
}