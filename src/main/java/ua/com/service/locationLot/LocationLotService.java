package ua.com.service.locationLot;

import ua.com.entity.LocationLot;

public interface LocationLotService {

    LocationLot getByIdLocationLot(int id_LocationLot);
    void addLocationLot(LocationLot locationLot);
}
