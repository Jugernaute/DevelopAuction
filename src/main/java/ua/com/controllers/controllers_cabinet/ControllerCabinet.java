package ua.com.controllers.controllers_cabinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.editor.UserEditor;
import ua.com.editor.UserValidator;
import ua.com.entity.User;
import ua.com.method.Mail;
import ua.com.service.UserService;

import java.util.List;

@Controller
@PropertySource("classpath:validation.properties")
public class ControllerCabinet {
    @Autowired
    private UserService userService;





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
