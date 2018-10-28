package ua.com.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.UserDao;
import ua.com.entity.User;
import ua.com.entity.UserConnection;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService, SocialUserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username);
    }

    // social
    //---------------------------------------
    @Override
    public SocialUserDetails loadUserByUserId(String userIdSocial) {
        return userDao.loadUserByUserId(userIdSocial);
    }

    @Override
    public User findByUserConnectionIn(UserConnection userConnection) {
        return userDao.findByUserConnectionIn(userConnection);
    }
  //------------------------------------------

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteBuId(int id) {
        userDao.delete(id);
    }

    @Override
    public User findOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findAll(int id) {
        return userDao.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findByRandomKey(String randomKey) {
        return userDao.findByRandomKey(randomKey);
    }

}
