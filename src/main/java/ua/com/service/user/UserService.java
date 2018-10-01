package ua.com.service.user;

        import org.springframework.security.core.userdetails.UserDetailsService;
        import ua.com.entity.User;

        import javax.jws.soap.SOAPBinding;
        import java.util.List;


public interface UserService extends UserDetailsService {

    void addUser(User user);
    void deleteUserById(int userId);
    void updateUser(User user);
    User getUserById(int userId);
    List<User> findAllUser();
    User findByUsername(String username);
    User findByRandomKey(String randomKey);
    User findByEmail(String email);

}
