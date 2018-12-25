package ua.com.method.filter.test;

public class ConditionLot<DT>{

    public String dataEndLot;
    public String dataStartLot;
    public String priceFrom;
    public String priceTo;

    public ConditionLot() {
    }

    public ConditionLot(String DT, String DA) {
        this.dataEndLot = DT;
        this.dataStartLot = DA;
    }

    public ConditionLot(String dataEndLot, String dataStartLot, String priceFrom, String priceTo) {
        this.dataEndLot = dataEndLot;
        this.dataStartLot = dataStartLot;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
    }
}
