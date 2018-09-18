package ua.com.service;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import ua.com.entity.CommonCategory;

import java.util.List;

@Transactional
public class DBService {

    public List<CommonCategory> getAllSpotDataSet(){
        Session session = sessionFactory.getCurrentSession();
        MySqlDAO dao = new MySqlDAO(session);
        return dao.getAllSpotDataSet();
    }
}
