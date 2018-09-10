package ua.com.service.delivery;

import ua.com.entity.Delivery;

public interface DeliveryService {

    void save(Delivery delivery);

    void deleteById(int id);
}
