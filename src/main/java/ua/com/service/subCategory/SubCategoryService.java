package ua.com.service.subCategory;

import ua.com.entity.SubCategory;

public interface SubCategoryService {
    void save(SubCategory subCategory);
    void deleteById(int id);
}
