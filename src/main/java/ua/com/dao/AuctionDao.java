package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Auction;

public interface AuctionDao extends JpaRepository<Auction, Integer > {
}
