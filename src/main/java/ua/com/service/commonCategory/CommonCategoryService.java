package ua.com.service.commonCategory;

import ua.com.entity.CommonCategory;

public interface CommonCategoryService {
    void save(CommonCategory commonCategory);
    void deleteById(int id);
}
