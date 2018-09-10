package ua.com.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.entity.User;


public interface UserService extends UserDetailsService {
    void save(User user);
    void deleteBuId(int id);

    }
