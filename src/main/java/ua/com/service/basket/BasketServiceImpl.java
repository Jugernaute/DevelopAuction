package ua.com.service.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.BasketDao;
import ua.com.entity.Basket;

import java.util.List;

@Service
@Transactional
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketDao basketDao;

    @Override
    public void addBasket(Basket basket) {
        if (basket != null){
        basketDao.save(basket);
    }
    }

    @Override
    public void deleteBasket(int idBasket) {
        basketDao.delete(idBasket);
    }

    @Override
    public List<Basket> findAllBasket() {
        return basketDao.findAll();
    }

    @Override
    public Basket getBasketById(int idBasket) {
        return basketDao.findOne(idBasket);
    }

}
