package ua.com.service.lot;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.dao.LotDao;
import ua.com.entity.Lot;

import java.util.List;

public class LotServiceImpl implements LotService {
    @Autowired
    LotDao lotDao;

    @Override
    public List<Lot> findAllLot() {
        return lotDao.findAll();
    }

    @Override
    public Lot getLotById(int idLot) {
        return lotDao.findOne(idLot);
    }

    @Override
    public void addLot(Lot lot) {
        lotDao.save(lot);
    }

    @Override
    public void updateLot(Lot lot) {
        lotDao.save(lot);
    }

    @Override
    public void deleteLotByIb(int idLot) {
        lotDao.delete(idLot);
    }
}
