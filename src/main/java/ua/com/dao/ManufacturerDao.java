package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Manufacturer;

import java.util.List;

public interface ManufacturerDao extends JpaRepository<Manufacturer, Integer> {

    List<Manufacturer> findAll();
}
