package ua.com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.entity.SubCategory;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer>{

    SubCategory findBy(String name);
    SubCategory findByNameSubCategory(String nameSubCategory);

//    @Modifying
    @Query(value = "SELECT * from subcategory join product p on subcategory.id_SubCategory = p.subCategory_id_SubCategory where id_Product=:idProduct", nativeQuery = true)
    SubCategory findSubCategoryByProducts (@Param("idProduct") int idProduct);
}
