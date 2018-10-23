package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Delivery;
import ua.com.entity.SubCategory;

public interface DeliveryDao extends JpaRepository<Delivery, Integer> {
    Delivery findByMethodDelivery(String methodDelivery);
}
