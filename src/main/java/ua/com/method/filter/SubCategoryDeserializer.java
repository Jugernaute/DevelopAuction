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


public class SubCategoryDeserializer extends JsonDeserializer<String> {

    private static final Logger logger = Logger.getLogger(SubCategoryDeserializer.class.getSimpleName());

@Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode tree = jsonParser.getCodec().readTree(jsonParser);
        String s = tree.get("subCategory").asText();
        System.out.println("jsondeserial "+s);


        return s;
    }
}
