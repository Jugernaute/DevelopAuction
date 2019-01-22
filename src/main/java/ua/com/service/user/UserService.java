package ua.com.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import ua.com.entity.User;
import ua.com.entity.UserConnection;

import javax.jws.soap.SOAPBinding;
import java.util.List;


public interface UserService extends UserDetailsService {
    void save(User user);
    void deleteBuId(int id);
    User findOne(int id);
    List<User> findAll(int id);
    User findByEmail(String email);
    User findByUsername(String username);
    User findByRandomKey(String randomKey);


    //social

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    SocialUserDetails loadUserByUserId(String userIdSocial);

    User findByUserConnectionIn(UserConnection userConnection);
}
