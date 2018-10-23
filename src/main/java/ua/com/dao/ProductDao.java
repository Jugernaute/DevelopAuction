package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Product;

public interface ProductDao  extends JpaRepository<Product, Integer> {
    Product findByNameProduct(String product);
}
