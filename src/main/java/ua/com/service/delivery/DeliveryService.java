package ua.com.service.delivery;

import ua.com.entity.Delivery;

import java.util.List;

public interface DeliveryService {

    void addDelivery(Delivery delivery);

    void deleteDeliveryById(int id_Delivery);

    void updateDelivery(Delivery delivery);
    Delivery getDeliveryById(int id_Delivery);
    List<Delivery> findAllDelivery();

    Delivery findByMethodDelivery(String methodDelivery);
}
