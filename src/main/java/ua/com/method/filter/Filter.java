package ua.com.method.filter;


import org.springframework.context.annotation.Condition;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class Filter implements Specification {

    List<Condition> conditions;
//    private SearchCriteria criteria;
    public Filter(String json) {
//        ObjectMapper mapper = new ObjectMapper();
//        this.conditions = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Condition.class));
    }

    public Filter() {
        conditions = new ArrayList<>();
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
