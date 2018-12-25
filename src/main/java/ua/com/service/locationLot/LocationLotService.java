package ua.com.service.locationLot;

import ua.com.entity.LocationLot;
import ua.com.method.filter.Filter;

import java.util.List;

public interface LocationLotService {

    LocationLot getByIdLocationLot(int id_LocationLot);
    void addLocationLot(LocationLot locationLot);
    List<LocationLot> findAllBySpecification(Filter filter);
}
