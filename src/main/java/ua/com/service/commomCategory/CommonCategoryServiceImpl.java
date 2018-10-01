package ua.com.service.commomCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.CommonCategoryDao;
import ua.com.entity.CommonCategory;

import java.util.List;

@Component
public class CommonCategoryServiceImpl implements CommonCategoryService {
    @Autowired
    CommonCategoryDao commonCategoryDao;

    @Override
    public CommonCategory findByNameCommonCategory(String name) {
        return commonCategoryDao.findByNameCommonCategory(name);
    }


//    @Override
//    public CommonCategory getCommonCategoryById_CommonCategory(int id_CommonCategory) {
//        return commonCategoryDao.getCommonCategoryById_CommonCategory(id_CommonCategory);
//    }
//
//    @Override
//    public void saveCommonCategory(CommonCategory commonCategory) {
//        commonCategoryDao.saveCommonCategory(commonCategory);
//    }
//
//    @Override
//    public void deleteCommonCategoryById_CommonCategory(int id_CommonCategory) {
//        commonCategoryDao.deleteCommonCategoryById_CommonCategory(id_CommonCategory);
//    }
}
