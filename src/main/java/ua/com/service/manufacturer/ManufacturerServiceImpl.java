package ua.com.service.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.ManufacturerDao;
import ua.com.entity.Manufacturer;

import java.util.List;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerDao manufacturerDao;


    @Override
    public void addManufacturer(Manufacturer manufacturer) {
        if (manufacturer != null){
            manufacturerDao.save(manufacturer);
        }
    }

    @Override
    public void deleteManufacturerById(int id_Manufacturer) {
        manufacturerDao.delete(id_Manufacturer);
    }

    @Override
    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturerDao.save(manufacturer);
    }

    @Override
    public Manufacturer getManufacturerById(int id_Manufacturer) {
        return manufacturerDao.findOne(id_Manufacturer);
    }

    @Override
    public List<Manufacturer> findAllManufacturer() {
        return manufacturerDao.findAll();
    }
}
