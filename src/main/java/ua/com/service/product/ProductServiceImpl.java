package ua.com.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.ProductDao;
import ua.com.entity.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public void save(Product product) {
        if (product != null){
            productDao.save(product);
        }
    }

    @Override
    public void deleteById(int id) {
        productDao.delete(id);
    }


}