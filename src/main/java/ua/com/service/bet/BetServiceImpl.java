package ua.com.service.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.BetDao;
import ua.com.entity.Bet;

import java.util.List;

@Service
@Transactional
public class BetServiceImpl implements BetService {

    @Autowired
    private BetDao betDao;

    @Override
    public void save(Bet bet) {
        if (bet != null) {
            betDao.save(bet);
        }
    }

    @Override
    public void deleteById(int id) {
        betDao.delete(id);

    }

    @Override
    public Bet findOne(int id) {
        return betDao.findOne(id);
    }

    @Override
    public List<Bet> findAll() {
        return betDao.findAll();
    }
}
