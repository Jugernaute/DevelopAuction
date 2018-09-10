package ua.com.service.lot;

import ua.com.entity.Lot;

public interface LotService {
    void save(Lot lot);
    void deleteById(int id);
}
