package ua.com.service.manufacturer;

import ua.com.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    void save(Manufacturer manufacturer);
    void deleteById(int id);
    Manufacturer findOne(int id);
    List<Manufacturer> findAll();
}
