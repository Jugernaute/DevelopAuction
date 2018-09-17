package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Delivery;

public interface DeliveryDao extends JpaRepository<Delivery, Integer> {
}
