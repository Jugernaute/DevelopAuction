package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Manufacturer;

public interface ManufacturerDao extends JpaRepository<Manufacturer, Integer> {
}
