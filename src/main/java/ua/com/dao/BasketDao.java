package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Basket;

public interface BasketDao extends JpaRepository<Basket, Integer> {
}
