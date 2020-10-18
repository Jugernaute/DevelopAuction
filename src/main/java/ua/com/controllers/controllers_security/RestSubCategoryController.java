package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.entity.SubCategory;
import ua.com.service.sudcategory.SubCategoryService;

import java.util.List;

@RestController
public class RestSubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/subcategories/page")
    public List<SubCategory> page(@RequestParam String page){
        int el  =Integer.parseInt(page);
        Page<SubCategory> allPage = subCategoryService.findAllPage(el, 10);
//        for (SubCategory subCategory : allPage) {
////            System.out.println(subCategory);
////        }
        List<SubCategory> content = allPage.getContent();
        return content;
    }

    @GetMapping ("/subcategories/previous/{currentPage}")
    public List<SubCategory> previous (@PathVariable int currentPage){

        Page<SubCategory> allPage = subCategoryService.findAllPage(currentPage, 10);
        if (!allPage.isFirst()){
            return subCategoryService.findAllPage(currentPage - 1, 10).getContent();
        }
        return allPage.getContent();
    }
}
