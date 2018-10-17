package ua.com.service.subcategory;

import ua.com.entity.SubCategory;

import java.util.List;

public interface SubСategoryService {

    void addSubCategory(SubCategory subCategory);
    void deleteSubCategoryById(int id_SubCategory);
    void updateSubCategory(SubCategory subCategory);
    SubCategory getSubCategoryById(int id_SubCategory);
    List<SubCategory> findAllSubCategory();
    SubCategory findByNameSubCategory (String nameSubCategory);
}
