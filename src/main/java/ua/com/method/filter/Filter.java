package ua.com.method.filter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.data.jpa.domain.Specification;
import ua.com.entity.Product;
import ua.com.entity.SubCategory;
import ua.com.entity.TypeSell;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.io.IOException;
import java.security.acl.Owner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Filter implements Specification {

    private List<Product> products;

    public Filter() {
        products = new ArrayList<>();
    }

    public void addCondition(List<Product> product) {
        this.products = product;
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

        products.forEach(product -> predicates.addAll(buildPredicate(product, root, criteriaQuery, criteriaBuilder)));
        return predicates;
    }

    public List<Predicate> buildPredicate(Product product, Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        switch (product.comparison) {
            case eq:
                return  buildEqualsPredicateToCriteria(product, root, criteriaQuery, criteriaBuilder);
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

    private List<Predicate> buildEqualsPredicateToCriteria(Product product, Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> criteriaBuilders=new ArrayList<>();
        List<Predicate> orPredicate = new ArrayList<>();
        switch (product.field) {

            case "locationLots":
                Root<Product> from = criteriaQuery.from(Product.class);
                EntityType<Product> Product_1 = from.getModel();
                criteriaBuilders.add(criteriaBuilder.equal(root.get(product.field), Product_1.getSet("locationLots")));
                return criteriaBuilders;

            case "nameSubCategory":
//                    for (int i = 0; i < product.nameSubCategory.size(); i++) {
//                        orPredicate.add(criteriaBuilder.equal(root.get(product.field), product.nameSubCategory.get(i).getNameSubCategory()));
//                    }
//                    criteriaBuilders.add(criteriaBuilder.or(orPredicate.toArray(new Predicate[0])));

                criteriaBuilders.add(criteriaBuilder.equal(root.get(product.field),product.getSubCategory().getNameSubCategory()));
                return criteriaBuilders;

            case "typeSell":
//                for (int i = 0; i < product.typeSell.size(); i++) {
//                    orPredicate.add(criteriaBuilder.equal(root.get(product.field), product.typeSell.get(i)));
//                }
//                criteriaBuilders.add(criteriaBuilder.or(orPredicate.toArray(new Predicate[0])));
//                criteriaQuery.from(Product.class).join(Product_.typeSell);
                criteriaBuilders.add(criteriaBuilder.equal(root.get(product.field),product.getTypeSell()));//
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
                "conditions=" + products +
                '}';
    }
}
