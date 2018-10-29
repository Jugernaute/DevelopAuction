package ua.com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.entity.Product;
import ua.com.entity.SubCategory;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer> {

    SubCategory findBy(String name);
    SubCategory findByNameSubCategory(String nameSubCategory);

    @Query("SELECT s.id_SubCategory from SubCategory s join Product p where p.id_Product=:idProduct")
    SubCategory findByProducts (@Param("idProduct") int idProduct);
}
