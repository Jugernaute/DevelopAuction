package ua.com.service.subcategory;

import org.springframework.data.domain.Page;
import ua.com.entity.SubCategory;
import ua.com.method.filter.Filter;

import java.util.List;


public interface SubCategoryService {

    void addSubCategory(SubCategory subCategory);
    void deleteSubCategoryById(int id_SubCategory);
    void updateSubCategory(SubCategory subCategory);
    SubCategory getSubCategoryById(int id_SubCategory);
    List<SubCategory> findAllSubCategory();
    SubCategory findByNameSubCategory (String nameSubCategory);
    SubCategory findById_Products (int idProduct);
    List findAllSubCategoryBySpecification(Filter filter);
    Page<SubCategory> findAllPage(int page, int size);
}
