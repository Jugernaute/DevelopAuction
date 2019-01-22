package ua.com.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.dao.UserDao;
import ua.com.entity.Bet;
import ua.com.entity.User;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username);
    }

    @Override
    public void addUser(User user) {
        if (user != null) {
            userDao.save(user);
        }
    }

    @Override
    public void deleteUserById(int userId) {
        userDao.delete(userId);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void lock(int userId) {
        User user = userDao.findOne(userId);
        user.setAccountNonLocked(false);
        user.setEnabled(false);
        userDao.save(user);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.findOne(userId);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAll();
    }

    @Override
    public User findByUsername(String user) {
        return userDao.findByUsername(user);
    }

    @Override
    public User findByRandomKey(String randomKey) {
        return userDao.findByRandomKey(randomKey);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findUserByProductId(int idProduct) {
        return userDao.findUserByProductId(idProduct);
    }

    @Override
    public List<Object[]> listBetAndUserByLot_id(int id_lot) {

        return userDao.listBetAndUserByLot_id(id_lot);
    }

    @Override
    public String getUsernameFromBetById_Bet(int id_bet) {
        return userDao.getUsernameFromBetById_Bet(id_bet);
    }
}
