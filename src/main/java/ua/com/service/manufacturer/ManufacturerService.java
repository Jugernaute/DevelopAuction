package ua.com.service.manufacturer;

import ua.com.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    void addManufacturer(Manufacturer manufacturer);
    void deleteManufacturerById(int id_Manufacturer);
    void updateManufacturer(Manufacturer manufacturer);
    Manufacturer getManufacturerById(int id_Manufacturer);
    List<Manufacturer> findAllManufacturer();
    Manufacturer findByNameManufacturer (String nameManufacturer);
}
