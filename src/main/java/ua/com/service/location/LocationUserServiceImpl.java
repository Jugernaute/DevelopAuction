package ua.com.service.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.dao.LocationUserDao;
import ua.com.entity.LocationUser;

@Service
public class LocationUserServiceImpl implements LocationUserService {
    @Autowired
    private LocationUserDao locationUserDao;

    @Override
    public void addLocation(LocationUser location) {
        locationUserDao.save(location);
    }
}
