package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.service.user.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/delete/{userId}")
    public String delete(@PathVariable int userId){
        userService.lock(userId);
        return "redirect:/users";
    }

}
