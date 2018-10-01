package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.entity.CommonCategory;

public interface CommonCategoryDao extends JpaRepository<CommonCategory, Integer> {

    CommonCategory findByNameCommonCategory(String name);
}
