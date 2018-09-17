package ua.com.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.dao.ProductDao;
import ua.com.entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAllProduct() {
        return productDao.findAll();
    }

    @Override
    public Product getProductById(int idProduct) {
        return productDao.findOne(idProduct);
    }

    @Override
    public void addProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteProductByIb(int idProduct) {
        productDao.delete(idProduct);
    }
}
