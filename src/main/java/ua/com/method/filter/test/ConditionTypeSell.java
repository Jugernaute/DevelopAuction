package ua.com.method.filter.test;

import ua.com.entity.TypeSell;

import java.util.List;

public class ConditionTypeSell {

    public List<TypeSell> typeSell;

    public ConditionTypeSell() {
    }

    public ConditionTypeSell(List<TypeSell> typeSell) {
        this.typeSell = typeSell;
    }

    public List<TypeSell> getTypeSell() {
        return typeSell;
    }

    public void setTypeSell(List<TypeSell> typeSell) {
        this.typeSell = typeSell;
    }

    @Override
    public String toString() {
        return "ConditionTypeSell{" +
                "typeSell=" + typeSell +
                '}';
    }
}
