package ua.com.service.subcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.SubCategory;

import java.util.List;

@Component
public class SubСategoryServiceImpl implements SubСategoryService {
    @Autowired
    private SubCategoryDao subCategoryDao;


    @Override
    public void addSubCategory(SubCategory subCategory) {
        if (subCategory !=null){
            subCategoryDao.save(subCategory);
        }
    }

    @Override
    public void deleteSubCategoryById(int id_SubCategory) {
        subCategoryDao.delete(id_SubCategory);
    }

    @Override
    public void updateSubCategory(SubCategory subCategory) {
        subCategoryDao.save(subCategory);
    }

    @Override
    public SubCategory getSubCategoryById(int id_SubCategory) {
        return subCategoryDao.findOne(id_SubCategory);
    }

    @Override
    public List<SubCategory> findAllSubCategory() {
        return subCategoryDao.findAll();
    }
}
