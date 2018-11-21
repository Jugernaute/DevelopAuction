package ua.com.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ua.com.entity.ImageLink;
import ua.com.entity.Product;
import ua.com.entity.User;
import ua.com.service.product.ProductService;
import ua.com.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoadAllLotOnMainPage {
    @Autowired
            private ProductService productService;

    public List loadAllLotOnMainPage(){
        List<Product> allProduct = productService.findAllProduct();
        List<ImageLink> imgLink = new ArrayList<>();
                for (Product product : allProduct) {
            List<ImageLink> imageLinks = product.getImageLinks();
    //            System.out.println("----"+imageLinks);
            if (!(imageLinks.size() == 0)){
                ImageLink imageLink = imageLinks.get(0);
                imgLink.add(imageLink);
            }else {
//                continue;
            }
                }
        return imgLink;
    }
}
