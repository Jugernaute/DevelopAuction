package ua.com.service.bet;

import ua.com.entity.Bet;

import java.util.List;

public interface BetService {
    void addBet(Bet bet);

    void deleteBet(int idBet);

    Bet getBetById(int idBet);

    List<Bet> findAllBet();

    void updateBet(Bet bet);
}
