package ua.com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.security.entity.Customer;


public interface CustomerDao extends JpaRepository<Customer,Integer> {

    Customer findByUsername(String username);
 }

