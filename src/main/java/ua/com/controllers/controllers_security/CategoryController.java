package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.entity.CommonCategory;
import ua.com.service.commonCategory.CommonCategoryService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CommonCategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model) {
        List<CommonCategory> categories = categoryService.findAllCommonCategory();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @PostMapping("/createCategory")
    public String createCategory(CommonCategory category) {
        categoryService.addCommonCategory(category);
        return "redirect:/categories";
    }
}
