package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Location;

public interface LocationDao extends JpaRepository<Location, Integer> {

}
