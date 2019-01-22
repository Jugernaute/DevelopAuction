package ua.com.service.commomCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.dao.CommonCategoryDao;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.CommonCategory;

import java.util.List;

@Service
public class CommonCategoryServiceImpl implements CommonCategoryService {
//    @Autowired
//    CommonCategoryDao commonCategoryDao;
//
//    @Autowired
//    SubCategoryDao subCategoryDao;
//    @Override
//    public List<CommonCategory> findAll() {
//        return commonCategoryDao.findAll();
//    }
//
//    @Override
//    public CommonCategory getById(int idCommonCategory) {
//        return commonCategoryDao.getOne(idCommonCategory);
//    }
//
//    @Override
//    public void addCommonCategory(CommonCategory commonCategory) {
//        commonCategoryDao.save(commonCategory);
//
//    }
//
//    @Override
//    public void updateCommonCategory(CommonCategory commonCategory) {
//        commonCategoryDao.save(commonCategory);
//    }
//
//    @Override
//    public void save(CommonCategory commonCategory) {
//        commonCategoryDao.save(commonCategory);
//    }
//
//    @Override
//    public void deleteCommonCategoryById(int idCommonCategory) {
//        commonCategoryDao.delete(idCommonCategory);
//    }
//
//    @Override
//    public CommonCategory findByNameCommonCategory(String name) {
//        return commonCategoryDao.findByNameCommonCategory(name);
//    }
@Autowired
private CommonCategoryDao commonCategoryDao;

    @Override
    public List<CommonCategory> findAllCommonCategory() {
        return commonCategoryDao.findAll();
    }

    @Override
    public CommonCategory getCommonCategoryById(int idCommonCategory) {
        return commonCategoryDao.findOne(idCommonCategory);
    }

    @Override
    public CommonCategory findByNameCommonCategory(String name) {
        return commonCategoryDao.findByNameCommonCategory(name);
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

    @Override
    public CommonCategory findCommonCategoriesBySubCategory(String subCategory) {
        return commonCategoryDao.findCommonCategoriesBySubCategory(subCategory);
    }

}
