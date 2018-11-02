package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.com.entity.CommonCategory;

public interface CommonCategoryDao extends JpaRepository<CommonCategory,Integer> {

    CommonCategory findByNameCommonCategory(String name);
    @Query(value = "select * from commoncategory join subcategory s on commoncategory.id_CommonCategory = s.commonCategory_id_CommonCategory where nameSubCategory=:id_Sub", nativeQuery = true)
    CommonCategory findCommonCategoriesBySubCategory(@Param("id_Sub") String subCategory);
}
