package ua.com.service.lot;

import ua.com.entity.Lot;

import java.util.List;

public interface LotService {
    void addLot(Lot lot);
    void deleteLotById(int id_Lot);
    void  updateLot(Lot lot);
    Lot getLotById(int id_Lot);
    List<Lot> findAllLot();
}
