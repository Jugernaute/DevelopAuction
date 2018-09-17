package ua.com.service.delivery;

import ua.com.entity.Delivery;

import java.util.List;

public interface DeliveryService {

    void save(Delivery delivery);

    void deleteById(int id);
    Delivery findOne(int id);
    List<Delivery> findAll();
}
