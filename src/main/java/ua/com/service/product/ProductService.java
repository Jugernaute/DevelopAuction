package ua.com.service.product;

import ua.com.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProduct();

    Product getProductById(int idProduct);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProductByIb(int idProduct);
}
