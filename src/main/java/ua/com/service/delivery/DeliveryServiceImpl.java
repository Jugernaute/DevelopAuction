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
    public void save(Delivery delivery) {
        if (delivery != null){
        deliveryDao.save(delivery);
    }
    }

    @Override
    public void deleteById(int id) {
        deliveryDao.delete(id);
    }

    @Override
    public Delivery findOne(int id) {
        return deliveryDao.findOne(id);
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryDao.findAll();
    }
}
