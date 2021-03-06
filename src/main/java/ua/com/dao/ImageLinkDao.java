package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.ImageLink;

import java.util.List;

public interface ImageLinkDao extends JpaRepository<ImageLink, Integer> {

    ImageLink findByLinkOfImage(String imageLink);
}
