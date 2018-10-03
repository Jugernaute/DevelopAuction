package ua.com.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.ProductDao;
import ua.com.entity.Product;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public void addProduct(Product product) {
        if (product != null){
        productDao.save(product);
    }
    }

    @Override
    public void deleteProductById(int id_Product) {
        productDao.delete(id_Product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public Product getProductById(int id_Product) {
        return productDao.findOne(id_Product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productDao.findAll();
    }
}
