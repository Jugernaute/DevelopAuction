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
    public void addPayment(Payment payment) {
        if(payment != null){
        paymentDao.save(payment);
    }

    }

    @Override
    public void deletePaymentById(int id_Payment) {
        paymentDao.delete(id_Payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(int id_Payment) {
        return paymentDao.findOne(id_Payment);
    }

    @Override
    public List<Payment> findAllPayment() {
        return paymentDao.findAll();
    }
}
