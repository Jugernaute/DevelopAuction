package ua.com.controllers.controllers_cabinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.entity.User;
import ua.com.service.UserService;


@Controller
@PropertySource("classpath:validation.properties")
public class ControllerCabinet {

    @Autowired
    private UserService userService;

    @GetMapping("/goToSell")
    public String goToSell(Model model){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        model.addAttribute("user",user);
        return "sell";
    }


}
