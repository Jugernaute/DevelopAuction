package ua.com.service.subCategory;

import ua.com.entity.SubCategory;

import java.util.List;

public interface SubCategoryService {
    void save(SubCategory subCategory);
    void deleteById(int id);
    SubCategory findOne(int id);
    List<SubCategory> findAll();
}
