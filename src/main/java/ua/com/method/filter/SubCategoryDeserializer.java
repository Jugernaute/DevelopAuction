package ua.com.method.filter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.entity.SubCategory;
import ua.com.service.subcategory.SubCategoryService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//@Component
public class SubCategoryDeserializer extends JsonDeserializer<List<SubCategory>> {
    
//    @Autowired
//    private SubCategoryService subCategoryService;
    private static final Logger logger = Logger.getLogger(SubCategoryDeserializer.class.getSimpleName());

//    @Override
    public List<SubCategory> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode tree = jsonParser.getCodec().readTree(jsonParser);
        List<SubCategory> subCategories = new ArrayList<>();
        for (int i = 0; i < tree.size(); i++) {

//            try{
//                SubCategory byNameSubCategory = subCategoryService.findByNameSubCategory("Охота");
//                System.out.println("sub "+byNameSubCategory);
//                subCategories.add(byNameSubCategory);
//            }catch (Exception e){
//                logger.info(e.getMessage());
//            }

        }
//        for (SubCategory subCategory : subCategories) {
//            System.out.println(subCategory);
//        }
        return subCategories;
    }
}
