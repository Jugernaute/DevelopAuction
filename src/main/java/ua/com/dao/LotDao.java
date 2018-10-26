package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.entity.Lot;

public interface LotDao extends JpaRepository<Lot, Integer > {

//    Lot findByProduct
//    @Query("select * from Lot join ")
}
