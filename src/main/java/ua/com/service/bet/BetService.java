package ua.com.service.bet;

import ua.com.entity.Bet;

public interface BetService {
    void save(Bet bet);

    void deleteById(int id);
}
