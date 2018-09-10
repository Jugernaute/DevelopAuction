package ua.com.service.payment;

import ua.com.entity.Payment;

public interface PaymentService {
    void save(Payment payment);
    void delete(int id);
}
