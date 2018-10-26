package ua.com.controllers.controllers_lot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.entity.ImageLink;
import ua.com.entity.Lot;
import ua.com.entity.Product;
import ua.com.service.lot.LotService;
import ua.com.service.product.ProductService;

import java.util.List;

@RestController
public class RestControllerLot {
    @Autowired
    private LotService lotService;
    @Autowired
    private ProductService productService;

    @PutMapping ("lot/loadImg")
    private String loadImg(){
        Lot lotById = lotService.getLotById(34);
        List<ImageLink> imageLinks = productService.getProductById(41).getImageLinks();
        for (ImageLink imageLink : imageLinks) {
            return imageLink.getLinkOfImage();
        }

        return "fdf";
    }
}
