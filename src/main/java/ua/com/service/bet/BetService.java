package ua.com.service.bet;

import ua.com.entity.Bet;

import java.util.List;

public interface BetService {

   List<Bet> findAllBet();
   Bet getBetById(int idBet);
   void addBet(Bet bet);
   void updateBet(Bet bet);
   void deleteBetByIb(int idBet);

}
