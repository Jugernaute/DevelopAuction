package ua.com.service.userconnect;

import ua.com.entity.UserConnection;

public interface UserConnectService {

    int countByProviderUserId(String providerUserId);

    void save(UserConnection userConnection);

    UserConnection findByProviderUserId(String id);

}
