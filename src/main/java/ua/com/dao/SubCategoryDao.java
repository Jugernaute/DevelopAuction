package ua.com.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ua.com.entity.Product;
import ua.com.entity.SubCategory;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer>,
        JpaSpecificationExecutor<SubCategory> {

    SubCategory findByNameSubCategory(String nameSubCategory);

//    @Modifying
    @Query(value = "SELECT * from subcategory join product p on subcategory.id_SubCategory = p.subCategory_id_SubCategory where id_Product=:idProduct", nativeQuery = true)
    SubCategory findSubCategoryByProducts (@Param("idProduct") int idProduct);
}
