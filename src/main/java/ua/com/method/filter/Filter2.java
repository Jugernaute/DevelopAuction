package ua.com.method.filter;

import org.springframework.data.jpa.domain.Specification;
import ua.com.entity.SubCategory;


public class Filter2 {

        public static Specification<SubCategory> products(String product) {
            return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("nameSubCategory"), product);
        }

}
