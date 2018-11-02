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
    public void addBet(Bet bet) {
        if (bet != null) {
            betDao.save(bet);
        }
    }

    @Override
    public void deleteBet(int idBet) {
        betDao.delete(idBet);
    }

    @Override
    public Bet getBetById(int idBet) {
        return betDao.findOne(idBet);
    }

    @Override
    public List<Bet> findAllBet() {
        return betDao.findAll();
    }

    @Override
    public void updateBet(Bet bet) {
        betDao.save(bet);
    }

    @Override
    public List<Bet> findAllBetByLot_id(int idLot) {
        return betDao.findAllBetByLot_id(idLot);
    }
}
