package ua.com.security.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.com.security.entity.Customer;


import java.beans.PropertyEditorSupport;

@Component
public class CustomerEditor  extends PropertyEditorSupport{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void setValue(Object value) {
        Customer customer = (Customer) value;
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    }

//            public void setValue( Object value) {
//               Customer customer = (Customer) value;
//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//    }
}
