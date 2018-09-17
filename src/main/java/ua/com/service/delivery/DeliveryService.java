package ua.com.service.delivery;

import ua.com.entity.Delivery;

import java.util.List;

public interface DeliveryService {

    List<Delivery> findAllDelivery();

    Delivery getDeliveryById(int idDelivery);

    void addDelivery(Delivery delivery);

    void updateDelivery(Delivery delivery);

    void deleteDeliveryByIb(int idDelivery);

}
