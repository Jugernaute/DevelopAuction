package ua.com.service.imageLink;


import ua.com.entity.ImageLink;

import java.util.List;

public interface ImageLinkService {

    void save (List<ImageLink> imageLinks);
    void save (ImageLink imageLink);
}
