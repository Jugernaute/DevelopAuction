package ua.com.service.manufacturer;

import ua.com.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    List<Manufacturer> findAllManufacturer();

    Manufacturer getManufacturerById(int idManufacturer);

    void addManufacturer(Manufacturer manufacturer);

    void updateManufacturer(Manufacturer manufacturer);

    void deleteManufacturerByIb(int idManufacturer);

}
