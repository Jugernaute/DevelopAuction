package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.LocationUser;

public interface LocationUserDao extends JpaRepository<LocationUser, Integer> {

}
