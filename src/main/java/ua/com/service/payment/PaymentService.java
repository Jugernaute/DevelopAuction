package ua.com.service.payment;

import ua.com.entity.Payment;

import java.util.List;

public interface PaymentService {
    void addPayment(Payment payment);
    void deletePaymentById(int id_Payment);
    void updatePayment(Payment payment);
    Payment getPaymentById(int id_Payment);
    List<Payment> findAllPayment();
}
