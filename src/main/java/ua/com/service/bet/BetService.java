package ua.com.service.bet;

import ua.com.entity.Bet;

import java.util.List;

public interface BetService {
    void save(Bet bet);

    void deleteById(int id);

    Bet findOne(int id);

    List<Bet> findAll();
}
