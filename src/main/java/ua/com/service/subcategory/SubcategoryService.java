package ua.com.service.subcategory;

import ua.com.entity.SubCategory;

import java.util.List;

public interface SubcategoryService {

    List<SubCategory> findAllSubcategory();

    SubCategory getSubcategoryById(int idSubcategory);

    void addSubcategory(SubCategory subCategory);

    void updateSubcategory(SubCategory subCategory);

    void deleteSubcategoryByIb(int idSubcategory);
}
