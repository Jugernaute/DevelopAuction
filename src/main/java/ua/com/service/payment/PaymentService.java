package ua.com.service.payment;

import ua.com.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findAllPayment();

    Payment getPaymentById(int idPayment);

    void addPayment(Payment payment);

    void updatePayment(Payment payment);

    void deletePaymentByIb(int idPayment);
}
