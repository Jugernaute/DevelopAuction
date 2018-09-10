package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.CommonCategory;

public interface CommonCategoryDao extends JpaRepository<CommonCategory, Integer> {
}
