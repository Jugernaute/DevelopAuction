package ua.com.service.imageLink;


import ua.com.entity.ImageLink;

import java.awt.*;
import java.util.List;

public interface ImageLinkService {

    void saveList (List<ImageLink> imageLinks);
    void addImageLink (ImageLink imageLink);
    List<ImageLink> findAll ();
    ImageLink findByImageLink(String imageLink);
}
