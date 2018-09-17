package ua.com.service.payment;

import ua.com.entity.Payment;

import java.util.List;

public interface PaymentService {
    void save(Payment payment);
    void delete(int id);
    Payment findOne(int id);
    List<Payment> findAll();
}
