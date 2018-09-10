package ua.com.service.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.ManufacturerDao;
import ua.com.entity.Manufacturer;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerDao manufacturerDao;

    @Override
    public void save(Manufacturer manufacturer) {
        if (manufacturer != null){
            manufacturerDao.save(manufacturer);
        }
    }

    @Override
    public void deleteById(int id) {
        manufacturerDao.delete(id);
    }
}
