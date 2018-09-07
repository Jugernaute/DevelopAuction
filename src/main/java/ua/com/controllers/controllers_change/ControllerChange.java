package ua.com.controllers.controllers_change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.entity.User;
import ua.com.service.UserService;

@Controller
public class ControllerChange {


    @Autowired
    private UserService userService;


    @PostMapping("/change_Email")
    private String changeEmail(@RequestParam String email,
                               Model model){
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setEmail(email);
        userService.save(user);
        model.addAttribute("user",user);
        return "cabinet";
    }

    @PostMapping("/change_Password")
    private String changePassword(@RequestParam String password,
                                  Model model){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        user.setPassword(password);
        userService.save(user);
        model.addAttribute("user",user);
        return "cabinet";
    }

    @PostMapping("change_Phone")
    private String changePone(@RequestParam String phone,
                              Model model){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        user.setPhone(phone);
        userService.save(user);
        model.addAttribute("user",user);
        return "cabinet";
    }
}
