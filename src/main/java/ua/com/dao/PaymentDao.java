package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer> {
}
