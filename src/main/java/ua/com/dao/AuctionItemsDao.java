package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Lot;

public interface AuctionItemsDao extends JpaRepository<Lot,Integer> {
}
