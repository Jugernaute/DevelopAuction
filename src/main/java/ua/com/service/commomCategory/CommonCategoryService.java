package ua.com.service.commomCategory;

import ua.com.entity.CommonCategory;

import java.util.List;

public interface CommonCategoryService {
//    List<CommonCategory>findAll();
//    CommonCategory getById(int idCommonCategory);
//    void addCommonCategory(CommonCategory commonCategory);
//    void updateCommonCategory(CommonCategory commonCategory);
//    void deleteCommonCategoryById(int idCommonCategory);
//    void save (CommonCategory commonCategory);
//    CommonCategory findByNameCommonCategory(String name);
List<CommonCategory>findAllCommonCategory();
    CommonCategory getCommonCategoryById(int idCommonCategory);
    CommonCategory findByNameCommonCategory(String name);
    void addCommonCategory(CommonCategory commonCategory);
    void updateCommonCategory(CommonCategory commonCategory);
    void deleteCommonCategoryByIb(int idCommonCategory);
    CommonCategory findCommonCategoriesBySubCategory(String subCategory);

}
