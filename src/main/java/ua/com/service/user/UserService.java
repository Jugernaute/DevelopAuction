package ua.com.service.user;

import org.springframework.data.repository.query.Param;
        import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.entity.Bet;
        import ua.com.entity.User;

        import javax.jws.soap.SOAPBinding;
        import java.util.List;
import java.util.Map;


public interface UserService extends UserDetailsService {

    void addUser(User user);
    void deleteUserById(int userId);
    void updateUser(User user);
    User getUserById(int userId);
    List<User> findAllUser();
    User findByUsername(String username);
    User findByRandomKey(String randomKey);
    User findByEmail(String email);
    User findUserByProductId(int idProduct);
    List<Object[]> listBetAndUserByLot_id(int id_lot);
    String getUsernameFromBetById_Bet (int bet);

}
