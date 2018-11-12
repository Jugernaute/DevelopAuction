package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.entity.Lot;

public interface LotDao extends JpaRepository<Lot, Integer > {

    @Query(value = "select * from lot join product p on lot.product_id_Product = p.id_Product where p.id_Product=:idProduct", nativeQuery = true)
    Lot findLotByProduct_Id(@Param("idProduct") int idProduct);
    @Query(value = "select lot.* from lot join product p on lot.product_id_Product = p.id_Product join imagelink i on p.id_Product = i.product_id_Product where i.linkOfImage=:imgLink",nativeQuery = true)
    Lot findLotByImageLink_Name(@Param("imgLink")String nameImgLink);

}
