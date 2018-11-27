package ua.com.service.basket;

import ua.com.entity.Basket;

import java.util.List;

public interface BasketService {

    void addBasket(Basket basket);

    void deleteBasket(int idBasket);

    List<Basket> findAllBasket();

    Basket getBasketById(int idBasket);

}
