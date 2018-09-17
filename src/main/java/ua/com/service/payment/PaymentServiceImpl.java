package ua.com.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.dao.PaymentDao;
import ua.com.entity.Payment;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;

    @Override
    public List<Payment> findAllPayment() {
        return paymentDao.findAll();
    }

    @Override
    public Payment getPaymentById(int idPayment) {
        return paymentDao.findOne(idPayment);
    }

    @Override
    public void addPayment(Payment payment) {
        paymentDao.save(payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentDao.save(payment);
    }

    @Override
    public void deletePaymentByIb(int idPayment) {
        paymentDao.delete(idPayment);
    }
}
