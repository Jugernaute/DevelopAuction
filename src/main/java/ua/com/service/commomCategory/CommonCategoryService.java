package ua.com.service.commomCategory;

import ua.com.entity.CommonCategory;

import java.util.List;

public interface CommonCategoryService {
    List<CommonCategory>findAllCommonCategory();
    CommonCategory getCommonCategoryById(int idCommonCategory);
    void addCommonCategory(CommonCategory commonCategory);
    void updateCommonCategory(CommonCategory commonCategory);
    void deleteCommonCategoryByIb(int idCommonCategory);

}
