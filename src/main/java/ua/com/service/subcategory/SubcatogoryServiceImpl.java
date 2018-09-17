package ua.com.service.subcategory;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.SubCategory;

import java.util.List;

public class SubcatogoryServiceImpl implements SubcategoryService {
    @Autowired
    SubCategoryDao subCategoryDao;

    @Override
    public List<SubCategory> findAllSubcategory() {
        return subCategoryDao.findAll();
    }

    @Override
    public SubCategory getSubcategoryById(int idSubcategory) {
        return subCategoryDao.findOne(idSubcategory);
    }

    @Override
    public void addSubcategory(SubCategory subCategory) {
        subCategoryDao.save(subCategory);
    }

    @Override
    public void updateSubcategory(SubCategory subCategory) {
        subCategoryDao.save(subCategory);
    }

    @Override
    public void deleteSubcategoryByIb(int idSubcategory) {
        subCategoryDao.delete(idSubcategory);
    }
}
