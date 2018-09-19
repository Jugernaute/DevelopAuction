package ua.com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.SubCategory;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer> {

    SubCategory findBy(String name);
}
