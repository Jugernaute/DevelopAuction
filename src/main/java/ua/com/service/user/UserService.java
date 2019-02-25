package ua.com.service.user;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import ua.com.entity.User;
import ua.com.entity.UserConnection;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;


public interface UserService extends UserDetailsService {

    void addUser(User user);
    void deleteUserById(int userId);
    void updateUser(User user);

    void lock(int userId);
    void unlock(int userId);
    User getUserById(int userId);
    List<User> findAllUser();
    User findByUsername(String username);
    User findByRandomKey(String randomKey);
    User findByEmail(String email);
    User findUserByProductId(int idProduct);
    User getUserFromBetById_Bet(int id_bet);
    List<Object[]> listBetAndUserByLot_id(int id_lot);
    String getUsernameFromBetById_Bet (int bet);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    SocialUserDetails loadUserByUserId(String userId);

    User findByUserConnectionIn(UserConnection userConnection);
    }
