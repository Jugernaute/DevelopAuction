package ua.com.service.commonCategory;

import ua.com.entity.CommonCategory;

import java.util.List;

public interface CommonCategoryService {
    void save(CommonCategory commonCategory);
    void deleteById(int id);
    CommonCategory findOne(int id);
    List<CommonCategory> findAll();
}
