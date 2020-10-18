package ua.com.method.filter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.entity.SubCategory;
import ua.com.service.sudcategory.SubCategoryService;

import java.io.IOException;


@Component
public class SubCategoryDeserializer extends JsonDeserializer<SubCategory> {

    @Autowired
    private SubCategoryService subCategoryService;

    public SubCategoryDeserializer() {
//            SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//        context.getAutowireCapableBeanFactory().autowireBean(this);
    //        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        }


    //    private static final Logger logger = Logger.getLogger(SubCategoryDeserializer.class.getSimpleName());

    @Override
    public SubCategory deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode tree = jsonParser.getCodec().readTree(jsonParser);

        String s = tree.asText();
        System.out.println("jsondeserial " + s);


//        List nameSub = manager.createNativeQuery("select sub.nameSubCategory from subcategory sub where nameSubCategory='foto'")
//                .setParameter("nameSub", s)
//        .getResultList();
//        System.out.println("new " + nameSub );


        SubCategory byNameSubCategory = subCategoryService.findByNameSubCategory(s);
        System.out.println("===================");
        return byNameSubCategory;
    }
}
