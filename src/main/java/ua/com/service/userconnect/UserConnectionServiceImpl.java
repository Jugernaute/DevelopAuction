package ua.com.service.userconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.UserConnectionDao;
import ua.com.entity.UserConnection;

@Service
@Transactional
public class UserConnectionServiceImpl implements UserConnectService {
    @Autowired
    UserConnectionDao userConnectionDao;

    @Override
    public int countByProviderUserId(String providerUserId) {
        return userConnectionDao.countByProviderUserId(providerUserId);
    }

    @Override
    public void save(UserConnection userConnection) {
        userConnectionDao.save(userConnection);

    }

    @Override
    public UserConnection findByProviderUserId(String providerUserId) {
        return userConnectionDao.findByProviderUserId(providerUserId);
    }
}
