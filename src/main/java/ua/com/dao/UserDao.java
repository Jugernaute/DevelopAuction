package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.security.SocialUserDetails;
import ua.com.entity.User;
import ua.com.entity.UserConnection;
//import ua.com.entity.User;


public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsername(String username);
    User findByUserId (int id);
    User save (User user);
    User findByRandomKey(String randomKey);
    User findByEmail(String email);

    //social
    @Query("select u from User u where u.username=:username")
    UserDetails loadUserByUsername(@Param("username") String username);

    @Query("select u from User u where u.userIdSocial=:userIdSocial")
    SocialUserDetails loadUserByUserId(@Param("userIdSocial") String userIdSocial);

    User findByUserConnectionIn(UserConnection userConnection);



 }

