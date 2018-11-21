package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.entity.Bet;
import ua.com.entity.User;

import java.util.List;


public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsername(String username);
    User findByUserId (int id);
    User save (User user);
    User findByRandomKey(String randomKey);
    User findByEmail(String email);
    @Query(value = "select * from user join product p on user.userId = p.userOwner_userId where id_Product=:idProd",nativeQuery = true)
    User findUserByProductId(@Param("idProd") int idProduct);
    @Query(value = "select * from user join bet b on user.userId = b.user_userId join lot l on b.lot_id_Lot = l.id_Lot where id_Lot=:id_lot",nativeQuery = true)
    List<Object[]> listBetAndUserByLot_id(@Param("id_lot") int id_lot);
    @Query(value = "select username, sum_of_the_bet from bet join lot l on bet.lot_id_Lot = l.id_Lot join user u on bet.user_userId = u.userId where id_Lot=:id_lot",nativeQuery = true)
    List<Object[]> findUserNameAndSumBetByLot_AndUserId(@Param("id_lot") int id_lot);
    @Query(value = "select username from bet join user u on bet.user_userId = u.userId where id_Bet=:id_bet", nativeQuery = true)
    String getUsernameFromBetById_Bet (@Param("id_bet") int id_bet);

 }

