package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.entity.Product;
import ua.com.service.payment.PaymentService;
import ua.com.service.product.ProductService;

import java.util.List;

@RestController
public class TestRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/giveProduct")
    public List<Product> allProductMethod(){
        return productService.findAll();
    }

    @PostMapping("/saveProduct")
    public List<Product> saveProduct(@RequestBody Product product){
       productService.save(product);
       return productService.findAll();

    }
}
