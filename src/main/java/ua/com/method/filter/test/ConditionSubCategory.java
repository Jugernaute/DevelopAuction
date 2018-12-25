package ua.com.method.filter.test;

import java.util.List;

public class ConditionSubCategory {
    public List<String> nameSubCategory;

    public ConditionSubCategory() {
    }

    public ConditionSubCategory(List<String> nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }

    public List<String> getNameSubCategory() {
        return nameSubCategory;
    }

    public void setNameSubCategory(List<String> nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }

    @Override
    public String toString() {
        return "ConditionSubCategory{" +
                "nameSubCategory=" + nameSubCategory +
                '}';
    }
}
