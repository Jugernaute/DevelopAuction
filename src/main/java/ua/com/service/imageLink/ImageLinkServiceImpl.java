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
    public void save(List<ImageLink> imageLinks) {
        imageLinkDao.save(imageLinks);
    }

    @Override
    public void save(ImageLink imageLink) {
        imageLinkDao.save(imageLink);
    }
}
