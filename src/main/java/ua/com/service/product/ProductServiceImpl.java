package ua.com.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.ProductDao;
import ua.com.entity.Product;
import ua.com.method.filter.Filter;

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

    @Override
    public Product findByNameProduct(String product) {
        return productDao.findByNameProduct(product);
    }

    @Override
    public Product findProductByLot_Id(int lot) {
        return productDao.findProductByLot_Id(lot);
    }

    @Override
    public Product findProductByImageLinks_Id(int idImgLink) {
        return productDao.findProductByImageLinks_Id(idImgLink);
    }

    @Override
    public List<Product> findAllBySpecification(Filter filter) {
        return productDao.findAll(filter);
    }

    @Override
    public List<Product> findAllByNameProductContaining(String matches) {
        return productDao.findAllByNameProductContaining(matches);
    }
}
