package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.entity.Bet;

import java.util.List;

public interface BetDao extends JpaRepository<Bet, Integer> {

    @Query(value = "select * from bet join lot l on bet.lot_id_Lot = l.id_Lot where lot_id_Lot=:id_lot", nativeQuery = true)
    List<Bet> findAllBetByLot_id(@Param("id_lot") int idLot);
}
