package ua.com.service.commonCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.CommonCategoryDao;
import ua.com.entity.CommonCategory;

@Service
@Transactional
public class CommonCategoryServiceImpl implements CommonCategoryService {
    @Autowired
    private CommonCategoryDao commonCategoryDao;

    @Override
    public void save(CommonCategory commonCategory) {
        if (commonCategory != null){
            commonCategoryDao.save(commonCategory);
        }
    }

    @Override
    public void deleteById(int id) {
        commonCategoryDao.delete(id);
    }
}
