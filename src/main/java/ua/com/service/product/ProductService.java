package ua.com.service.product;

import ua.com.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    void deleteById(int id);
    Product findOne(int id);
    List<Product> findAll();
}
