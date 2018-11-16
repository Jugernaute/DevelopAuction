package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.LocationLot;

public interface LocationLotDao extends JpaRepository<LocationLot, Integer> {
}
