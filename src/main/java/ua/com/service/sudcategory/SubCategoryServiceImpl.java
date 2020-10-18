package ua.com.service.sudcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.SubCategoryDao;
import ua.com.entity.SubCategory;
import ua.com.method.filter.Filter;

import java.util.List;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    private SubCategoryDao subCategoryDao;

    public SubCategoryServiceImpl() {
    }

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

    @Override
    public SubCategory findByNameSubCategory(String nameSubCategory) {
        return subCategoryDao.findByNameSubCategory(nameSubCategory);
    }

    @Override
    public SubCategory findById_Products(int idProduct) {
        return subCategoryDao.findSubCategoryByProducts(idProduct);
    }

    @Override
    public List findAllSubCategoryBySpecification(Filter filter) {
        return subCategoryDao.findAll(filter);
    }

    @Override
    public Page<SubCategory> findAllPage(int page,int size) {
        return subCategoryDao.findAll(new PageRequest(page, size));
    }


}
