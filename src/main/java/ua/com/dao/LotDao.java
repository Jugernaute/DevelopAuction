package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.entity.Lot;

public interface LotDao extends JpaRepository<Lot, Integer > {

//    Lot findByProduct
//    @Query("SELECT t.* FROM auction.lot_location t")

}
