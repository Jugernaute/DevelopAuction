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
//   @Autowired
//   private  SubCategoryDeserializer subCategoryDeserializer;

//    @JsonDeserialize(using = SubCategoryDeserializer.class)
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

    //    public static class Builder {
//        public List<String> nameSubCategory;
//        public String dataEndLot;
//        public String dataStartLot;
//        public String priceFrom;
//        public String priceTo;
//        public List<TypeSell> typeSell;
//        public Comparison comparison;
//        public LocationLot regionLot;
//        public String field;

//        public Builder setNameSubCategory(List<String> nameSubCategory) {
//            this.nameSubCategory = nameSubCategory;
//            return this;
//        }
//
//        public Builder setDataEndLot(String dataEndLot) {
//            this.dataEndLot = dataEndLot;
//            return this;
//        }
//
//        public Builder setDataStartLot(String dataStartLot) {
//            this.dataStartLot = dataStartLot;
//            return this;
//        }
//
//        public Builder setPriceFrom(String priceFrom) {
//            this.priceFrom = priceFrom;
//            return this;
//        }
//
//        public Builder setPriceTo(String priceTo) {
//            this.priceTo = priceTo;
//            return this;
//        }
//
//        public Builder setRegionLot(LocationLot regionLot) {
//            this.regionLot = regionLot;
//            return this;
//        }
//
//        public Builder setTypeSell(List<TypeSell> typeSell) {
//            this.typeSell = typeSell;
//            return this;
//        }
//
//        public Builder setComparison(Comparison comparison) {
//            this.comparison = comparison;
//            return this;
//        }
//
//        public Builder setField(String field) {
//            this.field = field;
//            return this;
//        }
//
//        public Condition build() {
//            return new Condition(nameSubCategory, dataEndLot, dataStartLot, priceFrom, priceTo, regionLot, typeSell, comparison, field);
//        }
//    }


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