package ua.com.method.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Condition {
    public List<String> nameSubCategory;
    public Comparison comparison = Comparison.eq;

    public Condition() {
    }

    public Condition(List<String> nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
        this.comparison = Comparison.eq;
    }

    public static class Builder {
        private Comparison comparison;
        List<String> nameSubCategory;

        public Builder setNameSubCategory(List<String> nameSubCategory) {
            this.nameSubCategory = nameSubCategory;
            return this;
        }

        public Builder setComparison() {
            this.comparison = Comparison.eq;
            return this;
        }

        public Condition build() {
            return new Condition(nameSubCategory);
        }
    }

    @Override
    public String toString() {
        return "Condition{" +
                "subCategory=" + nameSubCategory +
                ", comparison=" + comparison +
                '}';
    }
}