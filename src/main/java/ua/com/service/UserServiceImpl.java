package ua.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.dao.UserDao;
import ua.com.entity.User;


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
    public User findByUserId(int id) {
        return userDao.findByUserId(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findByRandomKey(String randomKey) {
        return userDao.findByRandomKey(randomKey);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }


}
