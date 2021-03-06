package ua.com.editor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.entity.User;


@Component
public class UserValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        System.out.println(aClass.equals(User.class));
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (user.getPassword().length() < 3) {
            errors.rejectValue("password", "message_pw.length.error");
        }
    }

    }

