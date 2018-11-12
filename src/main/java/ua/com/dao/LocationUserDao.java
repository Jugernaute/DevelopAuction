package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.entity.LocationUser;

public interface LocationUserDao extends JpaRepository<LocationUser, Integer> {
//    @Modifying
//    @Query(value = "update locationuser join user_locationuser u city=:city, country=:country, region=:region, userPostAddress=:address where user_userId=:id",
//            nativeQuery = true)
//    LocationUser updateLocationUserByUser_Id(@Param("city") String city,
//                                             @Param("country") String country,
//                                             @Param("region")String region,
//                                             @Param("id_user") int id_user);
}
