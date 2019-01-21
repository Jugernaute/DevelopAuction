package ua.com.method.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.entity.ImageLink;
import ua.com.entity.Product;
import ua.com.service.product.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ListImageLinks {
    @Autowired
    private ProductService productService;

    protected List<ImageLink> imageLinks(List<Product> products){
        List<ImageLink> imgLink = new ArrayList<>();
        for (Product product : products) {
            List<ImageLink> imageLinks = product.getImageLinks();
            if (!(imageLinks.size() == 0)){
                ImageLink imageLink = imageLinks.get(0);
                imgLink.add(imageLink);
            }
        }
        return imgLink;
    }

    protected List<ImageLink> imageLinks(String matchesWord){
        List<Product> allByNameProductContaining = productService.findAllByNameProductContaining(matchesWord);
        return imageLinks(allByNameProductContaining);
    }
}
