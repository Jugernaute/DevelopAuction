package ua.com.service.locationLot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.LocationLotDao;
import ua.com.entity.LocationLot;

@Service
@Transactional
public class LocationLotServiceImpl implements LocationLotService {

    @Autowired
    private LocationLotDao locationLotDao;


    @Override
    public LocationLot getByIdLocationLot(int id_LocationLot) {
        return locationLotDao.findOne(id_LocationLot);
    }

    @Override
    public void addLocationLot(LocationLot locationLot) {
        locationLotDao.save(locationLot);
    }

}
