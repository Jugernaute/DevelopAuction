package ua.com.service.lot;

import ua.com.entity.Lot;

import java.util.List;

public interface LotService {

    List<Lot> findAllLot();

    Lot getLotById(int idLot);

    void addLot(Lot lot);

    void updateLot(Lot lot);

    void deleteLotByIb(int idLot);

}
