package ua.com.service.lot;

import ua.com.entity.Lot;

import java.util.List;

public interface LotService {
    void save(Lot lot);
    void deleteById(int id);
    Lot findOne(int id);
    List<Lot> findAll();
}
