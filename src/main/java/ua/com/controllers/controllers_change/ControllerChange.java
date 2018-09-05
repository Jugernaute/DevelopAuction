package ua.com.controllers.controllers_change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.dao.UserDao;
import ua.com.entity.User;
import ua.com.service.UserService;

@Controller
public class ControllerChange {
    @Autowired
    private UserDao userDao;

    @GetMapping("change_Login")
    private String changeLogin(){
        return "forChange";
    }

    @PostMapping("/changeNick/{user}")
    private String changeNick(@RequestParam String changeNick,
                              @RequestParam String user){
        System.out.println(changeNick);
        System.out.println(user);
//        userDao.
        return "cabinet";
    }
}
