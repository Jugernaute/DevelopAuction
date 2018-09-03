package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.AuctionItems;

public interface AuctionItemsDao extends JpaRepository<AuctionItems,Integer> {
}
