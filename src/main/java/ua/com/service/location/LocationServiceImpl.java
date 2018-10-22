package ua.com.service.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.dao.LocationDao;
import ua.com.entity.Location;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationDao locationDao;

    @Override
    public void addLocation(Location location) {
        locationDao.save(location);
    }
}
