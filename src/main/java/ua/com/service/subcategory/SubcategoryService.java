package ua.com.service.subcategory;

import ua.com.entity.SubCategory;

import java.util.List;

public interface SubcategoryService {
//
//    List<SubCategory> findAll();
//
//    SubCategory getSubcategoryById(int idSubcategory);
//
//    void addSubcategory(SubCategory subCategory);
//
//    void updateSubcategory(SubCategory subCategory);
//
//    void deleteSubcategoryByIb(int idSubcategory);
//
//    void save (SubCategory subCategory);
//    SubCategory findByNameSubCategory (String nameSubCategory);
void addSubCategory(SubCategory subCategory);
    void deleteSubCategoryById(int id_SubCategory);
    void updateSubCategory(SubCategory subCategory);
    SubCategory getSubCategoryById(int id_SubCategory);
    List<SubCategory> findAllSubCategory();
    SubCategory findByNameSubCategory (String nameSubCategory);
    SubCategory findById_Products (int idProduct);
}
