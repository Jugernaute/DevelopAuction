package ua.com.method.filter.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) /*necessarily for deserialization Json*/
public class ConditionRegionLot {
    public String regionLot;

    public ConditionRegionLot() {
    }

    public ConditionRegionLot(String regionLot) {
        this.regionLot = regionLot;
    }

    public String getRegionLot() {
        return regionLot;
    }

    public void setRegionLot(String regionLot) {
        this.regionLot = regionLot;
    }

    @Override
    public String toString() {
        return "ConditionRegionLot{" +
                "regionLot='" + regionLot + '\'' +
                '}';
    }
}
