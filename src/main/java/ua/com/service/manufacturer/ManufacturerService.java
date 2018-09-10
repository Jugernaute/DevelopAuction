package ua.com.service.manufacturer;

import ua.com.entity.Manufacturer;

public interface ManufacturerService {
    void save(Manufacturer manufacturer);
    void deleteById(int id);
}
