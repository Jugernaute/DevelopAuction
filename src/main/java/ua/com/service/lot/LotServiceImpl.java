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
    public void save(Lot lot) {
      if (lot != null){
          lotDao.save(lot);
      }
    }

    @Override
    public void deleteById(int id) {
        lotDao.delete(id);

    }

    @Override
    public Lot findOne(int id) {
        return lotDao.findOne(id);
    }

    @Override
    public List<Lot> findAll() {
        return lotDao.findAll();
    }
}