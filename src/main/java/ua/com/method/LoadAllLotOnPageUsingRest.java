package ua.com.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.entity.ImageLink;
import ua.com.entity.Product;
import ua.com.method.error_log.Logs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class LoadAllLotOnPageUsingRest {

@Autowired
private Logs logs;
/*
* this method oriented on rest query from ajax and return result as a map
* with key---> count
*       value -> list,
*       where:
     *       value(Map<String,String>) is Lot(include Product & ImageLink), from witch we extract
      *       difference field, which will be displayed on view;
      *
      *       key(Integer) is just a number, that shows that value exists
  *       */
public Map<Integer,Map<String, String>> loadAllLotOnPageUsingRest(List<ImageLink> linkList){

    Map<Integer,Map<String, String>> listMap = new HashMap<>();
    int count=0;
        for (ImageLink imageLink : linkList) {
        Product product = imageLink.getProduct();
        count++;
        Map<String, String> list = new HashMap<>();
        list.put("imgLink",imageLink.getLinkOfImage());
        list.put("idProduct",String.valueOf(product.getId_Product()));
        list.put("nameProduct", product.getNameProduct());
        list.put("modelProduct", product.getModelProduct());
            LocalDateTime dataEndLot = product.getLot().getDataEndLot();
            DateTimeFormatter ru = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm").withLocale(new Locale("ru"));
            String format = ru.format(dataEndLot);
//            System.out.println(">>>>>>>>>>>"+format);
            try{
            list.put("dataEndLot",format);
        }catch (Exception e){
            logs.logError(e);
        }
        list.put("currentPrice", String.valueOf(product.getLot().getCurrentPrice()));
        listMap.put(count, list);
    }
    return listMap;
}

}
