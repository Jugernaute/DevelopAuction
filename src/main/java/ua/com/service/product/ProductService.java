package ua.com.service.product;

import ua.com.entity.Product;

public interface ProductService {
    void save(Product product);
    void deleteById(int id);
}
