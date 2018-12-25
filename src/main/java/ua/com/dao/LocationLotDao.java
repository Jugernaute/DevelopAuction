package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ua.com.entity.LocationLot;

public interface LocationLotDao extends JpaRepository<LocationLot, Integer>,
        JpaSpecificationExecutor <LocationLot>{
}
