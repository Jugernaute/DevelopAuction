package ua.com.service.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.dao.BetDao;
import ua.com.entity.Bet;
import ua.com.entity.Lot;
import ua.com.entity.User;

import java.util.List;

public class BetServiceImpl implements BetService {
    @Autowired
    BetDao betDao;


    @Override
    public List<Bet> findAllBet() {
        return betDao.findAll();
    }

    @Override
    public Bet getBetById(int idBet) {
        return betDao.findOne(idBet);
    }

    @Override
    public void addBet(Bet bet) {
        betDao.save(bet);
    }


    @Override
    public void updateBet(Bet bet) {
        betDao.save(bet);
    }

    @Override
    public void deleteBetByIb(int idBet) {
        betDao.delete(idBet);
    }


}
