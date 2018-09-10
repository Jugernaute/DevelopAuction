package ua.com.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.DeliveryDao;
import ua.com.entity.Delivery;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryDao deliveryDao;

    @Override
    public void save(Delivery delivery) {
        if (delivery != null){
            deliveryDao.save(delivery);
        }
    }

    @Override
    public void deleteById(int id) {
        deliveryDao.delete(id);
    }
}
