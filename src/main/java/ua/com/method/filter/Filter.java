package ua.com.method.filter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.data.jpa.domain.Specification;
import ua.com.entity.Product;
import ua.com.entity.TypeSell;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.Metamodel;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Filter implements Specification {

    private List<Condition> conditions;

    public Filter() {
        conditions = new ArrayList<>();
    }

    public void addCondition(List<Condition> condition) {
        this.conditions=(condition);
    }


    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = buildPredicates(root, criteriaQuery, criteriaBuilder);
        return predicates.size() > 1
                ? criteriaBuilder.and(predicates.toArray(new Predicate[0]))
                : predicates.get(0);
    }

    private List<Predicate> buildPredicates(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
//       return conditions.stream().map(this::buildPredicate).collect(toList());

        List<Predicate> predicates = new ArrayList<>();
//        for (Condition condition : conditions) {
//            System.out.println("------> "+condition.toString());
//        }

        conditions.forEach(condition -> predicates.addAll(buildPredicate(condition, root, criteriaQuery, criteriaBuilder)));
        return predicates;
    }

    public List<Predicate> buildPredicate(Condition condition, Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        switch (condition.comparison) {
            case eq:
                return  buildEqualsPredicateToCriteria(condition, root, criteriaQuery, criteriaBuilder);
            case gt:
                break;
            case lt:
                break;
            case ne:
                break;
            case in:
                break;
//            default:
//                return buildEqualsPredicateToCriteria(condition, root, criteriaQuery, criteriaBuilder);
        }
        throw new RuntimeException();
    }

    private List<Predicate> buildEqualsPredicateToCriteria(Condition condition, Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> criteriaBuilders=new ArrayList<>();
        List<Predicate> orPredicate = new ArrayList<>();
        switch (condition.field) {

            case "regionLot":
                criteriaBuilders.add(criteriaBuilder.equal(root.get(condition.field), condition.regionLot.getRegionLot()));
                return criteriaBuilders;

            case "nameSubCategory":
                    for (int i = 0; i < condition.nameSubCategory.size(); i++) {
                        orPredicate.add(criteriaBuilder.equal(root.get(condition.field), condition.nameSubCategory.get(i).getNameSubCategory()));
                    }
                    criteriaBuilders.add(criteriaBuilder.or(orPredicate.toArray(new Predicate[0])));
                return criteriaBuilders;

            case "typeSell":
                for (int i = 0; i < condition.typeSell.size(); i++) {
                    orPredicate.add(criteriaBuilder.equal(root.get(condition.field), condition.typeSell.get(i)));
                }
                criteriaBuilders.add(criteriaBuilder.or(orPredicate.toArray(new Predicate[0])));

                return criteriaBuilders;
//            case ne:
//                break;
//            case in:
//                break;
//            default:
//                return buildEqualsPredicateToCriteria(condition, root, criteriaQuery, criteriaBuilder);
        }
//        return criteriaBuilder.equal(root.get(condition.field), condition.regionLot);
        System.out.println("error switch");
        throw new RuntimeException();
//        return null;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "conditions=" + conditions +
                '}';
    }
}
