package ua.com.security.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.security.entity.Customer;

public  interface CustomerService extends UserDetailsService {

    void save (Customer customer);
}
