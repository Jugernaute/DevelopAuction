package ua.com.service.commomCategory;

import org.springframework.transaction.annotation.Transactional;
import ua.com.entity.CommonCategory;

import java.util.List;

public interface CommonCategoryService {
//    List<CommonCategory>findAllCommonCategory();
    CommonCategory findByNameCommonCategory(String name);
//    void addCommonCategory(CommonCategory commonCategory);
//    void updateCommonCategory(CommonCategory commonCategory);
//    void deleteCommonCategoryByIb(int idCommonCategory);

}
