package ua.com.service.product;

import ua.com.entity.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void deleteProductById(int id_Product);
    void updateProduct(Product product);
    Product getProductById(int id_Product);
    List<Product> findAllProduct();
    Product findByNameProduct(String product);
}
