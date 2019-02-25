package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.entity.CommonCategory;
import ua.com.entity.Lot;
import ua.com.entity.User;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.lot.LotService;
import ua.com.service.user.UserService;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommonCategoryService categoryService;
    @Autowired
    private LotService lotService;

//    @GetMapping("/login")
//    public String getLoginPage() {
//        return "login";
//    }

    @GetMapping("/administr")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<CommonCategory> categories = categoryService.findAllCommonCategory();
        long count = categories.stream().count();
        List<User> users = userService.findAllUser();
        long userCount = users.stream().count();
        List<Lot> lots = lotService.findAllLot();
        long lotCount = lots.stream().count();
        model.addAttribute("userCount", userCount);
        model.addAttribute("users", users);
        model.addAttribute("categoryCount", count);
        model.addAttribute("lotCount", lotCount);
        return "dashboard";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
