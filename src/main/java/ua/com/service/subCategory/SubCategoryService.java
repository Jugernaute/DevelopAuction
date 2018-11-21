package ua.com.service.subCategory;

import ua.com.entity.Product;
import ua.com.entity.SubCategory;

import java.util.List;

public interface SubCategoryService {

    void addSubCategory(SubCategory subCategory);
    void deleteSubCategoryById(int id_SubCategory);
    void updateSubCategory(SubCategory subCategory);
    SubCategory getSubCategoryById(int id_SubCategory);
    List<SubCategory> findAllSubCategory();
    SubCategory findByNameSubCategory (String nameSubCategory);
    SubCategory findById_Products (int idProduct);
}
