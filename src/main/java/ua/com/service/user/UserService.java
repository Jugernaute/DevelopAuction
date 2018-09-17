package ua.com.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;


public interface UserService extends UserDetailsService {
    void save(User user);
    void deleteBuId(int id);
    User findOne(int id);
    List<User> findAll(int id);

    }
