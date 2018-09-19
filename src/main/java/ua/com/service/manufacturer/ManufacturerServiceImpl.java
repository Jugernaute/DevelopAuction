package ua.com.service.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.dao.ManufacturerDao;
import ua.com.entity.Manufacturer;

import java.util.List;
@Component
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    ManufacturerDao manufacturerDao;

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerDao.findAll();
    }

//    @Override
//    public Manufacturer getManufacturerById(int idManufacturer) {
//        return manufacturerDao.findOne(idManufacturer);
//    }
//
//    @Override
//    public void addManufacturer(Manufacturer manufacturer) {
//        manufacturerDao.save(manufacturer);
//
//    }
//
//    @Override
//    public void updateManufacturer(Manufacturer manufacturer) {
//        manufacturerDao.save(manufacturer);
//    }
//
//    @Override
//    public void deleteManufacturerByIb(int idManufacturer) {
//        manufacturerDao.delete(idManufacturer);
//
//    }
}
