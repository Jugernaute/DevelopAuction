package ua.com.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.com.entity.User;


import java.beans.PropertyEditorSupport;

@Component
public class UserEditor  extends PropertyEditorSupport{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void setValue(Object value) {
        User user = (User) value;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

//            public void setValue( Object value) {
//               Customer customer = (Customer) value;
//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//    }
}
