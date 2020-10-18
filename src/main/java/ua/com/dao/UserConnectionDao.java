package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.UserConnection;

public interface UserConnectionDao extends JpaRepository<UserConnection, Integer> {

    int countByProviderUserId(String providerUserId);

    UserConnection findByProviderUserId(String id);

}
