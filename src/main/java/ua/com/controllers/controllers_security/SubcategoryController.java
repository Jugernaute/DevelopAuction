package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.entity.CommonCategory;
import ua.com.entity.Product;
import ua.com.entity.SubCategory;
import ua.com.service.commomCategory.CommonCategoryService;
import ua.com.service.subcategory.SubcategoryService;

import java.util.List;

@Controller
public class SubcategoryController {
    @Autowired
    private SubcategoryService subCategoryService;

    @Autowired
    private CommonCategoryService categoryService;


    @GetMapping("/subcategories")
    public String subcategories(Model model) {
        List<SubCategory> subcategories = subCategoryService.findAllSubCategory();
        List<CommonCategory> categories = categoryService.findAllCommonCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("subcategories", subcategories);
        return "subcategories";
    }

    @PostMapping("/createSubcategory")
    public String create(@RequestParam int id_CommonCategory, SubCategory subcategory) {
        CommonCategory category = categoryService.getCommonCategoryById(id_CommonCategory);
        subcategory.setCommonCategory(category);
        subCategoryService.addSubCategory(subcategory);
        return "redirect:/subcategories";
    }

    @GetMapping("/subcategories/delete/{id_SubCategory}")
    public String delete(@PathVariable int id_SubCategory){
        SubCategory subCategoryById = subCategoryService.getSubCategoryById(id_SubCategory);
        List<Product> products = subCategoryById.getProducts();
        if(products.size()==0) {
            subCategoryService.deleteSubCategoryById(id_SubCategory);
        } else{
            return "You can't delete subcategory with products";
        }
        return "redirect:/subcategories";
    }
    
}
