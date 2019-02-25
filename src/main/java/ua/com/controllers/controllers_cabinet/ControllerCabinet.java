package ua.com.controllers.controllers_cabinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.com.entity.CommonCategory;
import ua.com.entity.User;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.user.UserService;

import java.util.List;


@Controller
@PropertySource("classpath:validation.properties")
public class ControllerCabinet {

    @Autowired
    private UserService userService;
    @Autowired
    private CommonCategoryService commonCategoryService;

    @GetMapping("/goToSell")
    public String goToSell(Model model){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
        User user = userService.findByUsername(name);
        if (name.equals("anonymousUser") || !user.isEnabled()){
            return "needRegistration";
        }
        List<CommonCategory> allCommonCategory = commonCategoryService.findAllCommonCategory();
        model.addAttribute("commonList", allCommonCategory);
        model.addAttribute("user",user);
        return "createLot";
    }


}
