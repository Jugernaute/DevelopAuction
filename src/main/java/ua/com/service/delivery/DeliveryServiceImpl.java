package ua.com.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.DeliveryDao;
import ua.com.entity.Delivery;

import java.util.List;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryDao deliveryDao;


    @Override
    public void addDelivery(Delivery delivery) {
        if (delivery != null){
        deliveryDao.save(delivery);
    }
    }

    @Override
    public void addDeliveries(List<Delivery> delivery) {
        deliveryDao.save(delivery);
    }

    @Override
    public void deleteDeliveryById(int id_Delivery) {
        deliveryDao.delete(id_Delivery);
    }


    @Override
    public void updateDelivery(Delivery delivery) {
        deliveryDao.save(delivery);
    }

    @Override
    public Delivery getDeliveryById(int id_Delivery) {
        return deliveryDao.findOne(id_Delivery);
    }

    @Override
    public List<Delivery> findAllDelivery() {
        return deliveryDao.findAll();
    }

    @Override
    public Delivery findByMethodDelivery(String methodDelivery) {
        return deliveryDao.findByMethodDelivery(methodDelivery);
    }
}
