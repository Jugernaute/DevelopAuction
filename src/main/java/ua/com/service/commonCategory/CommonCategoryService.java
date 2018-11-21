package ua.com.service.commonCategory;

import org.springframework.transaction.annotation.Transactional;
import ua.com.entity.CommonCategory;

import java.util.List;

public interface CommonCategoryService {
    List<CommonCategory>findAllCommonCategory();
    CommonCategory getCommonCategoryById(int idCommonCategory);
    CommonCategory findByNameCommonCategory(String name);
    void addCommonCategory(CommonCategory commonCategory);
    void updateCommonCategory(CommonCategory commonCategory);
    void deleteCommonCategoryByIb(int idCommonCategory);
    CommonCategory findCommonCategoriesBySubCategory(String subCategory);

}
