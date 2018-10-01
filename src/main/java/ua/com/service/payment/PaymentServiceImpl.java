package ua.com.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.PaymentDao;
import ua.com.entity.Payment;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public void save(Payment payment) {
        if(payment != null){
        paymentDao.save(payment);
    }
    }

    @Override
    public void delete(int id) {
        paymentDao.delete(id);
    }

    @Override
    public Payment findOne(int id) {
        return paymentDao.findOne(id);
    }

    @Override
    public List<Payment> findAll() {
        return paymentDao.findAll();
    }
}
