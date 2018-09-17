package ua.com.service.subCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.SubCategory;

import java.util.List;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    private SubCategoryDao subCategoryDao;

    @Override
    public void save(SubCategory subCategory) {
        if (subCategory !=null){
            subCategoryDao.save(subCategory);
        }
    }

    @Override
    public void deleteById(int id) {
        subCategoryDao.delete(id);
    }

    @Override
    public SubCategory findOne(int id) {
        return subCategoryDao.findOne(id);
    }

    @Override
    public List<SubCategory> findAll() {
        return subCategoryDao.findAll();
    }
}
