package ua.com.method.filter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ConditionDao extends JpaSpecificationExecutor<Condition> {
}
