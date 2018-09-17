package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Bet;

public interface BetDao extends JpaRepository<Bet, Integer> {
}
