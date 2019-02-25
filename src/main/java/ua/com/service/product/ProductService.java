package ua.com.service.product;

import ua.com.entity.Product;
import ua.com.entity.User;
import ua.com.method.filter.Filter;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void deleteProductById(int id_Product);
    void updateProduct(Product product);
    Product getProductById(int id_Product);
    List<Product> findAllProduct();
    Product findByNameProduct(String product);
    Product findProductByLot_Id (int lot);
    Product findProductByImageLinks_Id(int idImgLink);
    List findAllBySpecification(Filter filter);
    List<Product> findAllByNameProductContaining(String matches);
    User findProductByUserOwnerId(int userId);
}
