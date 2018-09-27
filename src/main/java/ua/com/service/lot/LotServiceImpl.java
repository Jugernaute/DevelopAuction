package ua.com.service.lot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.LotDao;
import ua.com.entity.Lot;

import java.util.List;

@Service
@Transactional
public class LotServiceImpl implements LotService {
    @Autowired
    private LotDao lotDao;


    @Override
    public void addLot(Lot lot) {
        if (lot != null){
            lotDao.save(lot);
        }
    }

    @Override
    public void deleteLotById(int id_Lot) {
        lotDao.findOne(id_Lot);
    }

    @Override
    public void updateLot(Lot lot) {
        lotDao.save(lot);
    }

    @Override
    public Lot getLotById(int id_Lot) {
        return lotDao.findOne(id_Lot);
    }

    @Override
    public List<Lot> findAllLot() {
        return lotDao.findAll();
    }
}
