package ua.com.service.imageLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.ImageLinkDao;
import ua.com.entity.ImageLink;

import java.util.List;

@Service
//@Transactional
public class ImageLinkServiceImpl implements ImageLinkService {
    @Autowired
    private ImageLinkDao imageLinkDao;

    @Override
    public void saveList(List<ImageLink> imageLinks) {
        for (ImageLink imageLink : imageLinks) {
            imageLinkDao.save(imageLink);
        }

    }

    @Override
    public void addImageLink(ImageLink imageLink) {
       imageLinkDao.save(imageLink);
    }
}
