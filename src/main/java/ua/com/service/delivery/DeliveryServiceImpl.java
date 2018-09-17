package ua.com.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.dao.DeliveryDao;
import ua.com.entity.Delivery;

import java.util.List;

public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    DeliveryDao deliveryDao;

    @Override
    public List<Delivery> findAllDelivery() {
        return deliveryDao.findAll();
    }

    @Override
    public Delivery getDeliveryById(int idDelivery) {
        return deliveryDao.findOne(idDelivery);
    }

    @Override
    public void addDelivery(Delivery delivery) {
        deliveryDao.save(delivery);
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        deliveryDao.save(delivery);
    }

    @Override
    public void deleteDeliveryByIb(int idDelivery) {

    }
}
