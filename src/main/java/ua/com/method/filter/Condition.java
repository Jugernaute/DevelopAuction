package ua.com.method.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Component;
import ua.com.entity.LocationLot;
import ua.com.entity.SubCategory;
import ua.com.entity.TypeSell;
import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true) /*necessarily for deserialization Json*/
public class Condition {

    @JsonDeserialize(using = SubCategoryDeserializer.class)
    public List<SubCategory> nameSubCategory;
    @JsonDeserialize(using = LocalDataTimeDeserializer.class)
    public String dataEndLot;
    @JsonDeserialize(using = LocalDataTimeDeserializer.class)
    public String dataStartLot;
    public String priceFrom;
    public String priceTo;
    public LocationLot regionLot;
    public List<TypeSell> typeSell;
    public Comparison comparison;
    public String field;

    /*
    * this default constructor is necessarily for deserialization Json
    * */
    public Condition() {
    }

    public Condition(List<SubCategory> nameSubCategory, String dataEndLot, String dataStartLot, String priceFrom, String priceTo, LocationLot regionLot, List<TypeSell> typeSell, Comparison comparison, String field) {
        this.nameSubCategory = nameSubCategory;
        this.dataEndLot = dataEndLot;
        this.dataStartLot = dataStartLot;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.regionLot = regionLot;
        this.typeSell = typeSell;
        this.comparison = comparison;
        this.field = field;
}


    @Override
    public String toString() {
        return "Condition{" +
                "nameSubCategory=" + nameSubCategory +
                ", dataEndLot='" + dataEndLot + '\'' +
                ", dataStartLot='" + dataStartLot + '\'' +
                ", priceFrom='" + priceFrom + '\'' +
                ", priceTo='" + priceTo + '\'' +
                ", regionLot=" + regionLot +
                ", typeSell=" + typeSell +
                ", comparison=" + comparison +
                ", field='" + field + '\'' +
                '}';
    }
}