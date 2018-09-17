package ua.com.service.commomCategory;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.dao.CommonCategoryDao;
import ua.com.entity.CommonCategory;

import java.util.List;

public class CommonCategoryServiceImpl implements CommonCategoryService {
    @Autowired
    CommonCategoryDao commonCategoryDao;

    @Override
    public List<CommonCategory> findAllCommonCategory() {
        return commonCategoryDao.findAll();
    }

    @Override
    public CommonCategory getCommonCategoryById(int idCommonCategory) {
        return commonCategoryDao.findOne(idCommonCategory);
    }

    @Override
    public void addCommonCategory(CommonCategory commonCategory) {
        commonCategoryDao.save(commonCategory);

    }

    @Override
    public void updateCommonCategory(CommonCategory commonCategory) {
        commonCategoryDao.save(commonCategory);
    }

    @Override
    public void deleteCommonCategoryByIb(int idCommonCategory) {
        commonCategoryDao.delete(idCommonCategory);
    }
}
