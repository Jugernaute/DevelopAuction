package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.entity.CommonCategory;
import ua.com.entity.Product;
import ua.com.entity.SubCategory;
import ua.com.service.commonCategory.CommonCategoryService;
import ua.com.service.sudcategory.SubCategoryService;
//import ua.com.service.subcategory.SubcategoryService;

import java.util.List;

@Controller
public class SubcategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private CommonCategoryService categoryService;


    @GetMapping("/subcategories")
    public String subcategories(Model model) {
        List<SubCategory> subcategories = subCategoryService.findAllSubCategory();
        List<CommonCategory> categories = categoryService.findAllCommonCategory();
        Page<SubCategory> allPage = subCategoryService.findAllPage(0, 10);
        System.out.println("total elements" + allPage.getTotalElements());
        System.out.println("total page" + allPage.getTotalPages());
        int c = 0;
        for (SubCategory subCategory : allPage) {
            c++;
            System.out.println(c + " - " + subcategories);
        }
        int totalPages = allPage.getTotalPages();
        long totalElements = allPage.getTotalElements();
        boolean last = allPage.isLast();
        int number = allPage.getNumber();
        model.addAttribute("categories", categories);
        model.addAttribute("subcategories", allPage);
        model.addAttribute("totalPages", totalPages);
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
