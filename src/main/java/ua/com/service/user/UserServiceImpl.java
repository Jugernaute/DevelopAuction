package ua.com.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.dao.UserDao;
import ua.com.entity.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username);
    }

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


}
