package ua.com.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.entity.User;


public interface UserService extends UserDetailsService {
    void save(User user);

    }
