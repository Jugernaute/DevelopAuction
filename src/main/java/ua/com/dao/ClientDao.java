package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.entity.Client;

public interface ClientDao extends JpaRepository <Client, Integer> {

}
