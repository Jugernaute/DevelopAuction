package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.User;


public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsername(String username);
    User findByUserId (int id);
 }

