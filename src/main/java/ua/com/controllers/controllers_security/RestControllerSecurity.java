package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ua.com.editor.UserEditor;
import ua.com.editor.UserValidator;
import ua.com.entity.User;
import ua.com.method.Mail;
import ua.com.method.RandomStr;
import ua.com.service.user.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class RestControllerSecurity {

    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private Environment environment;
    @Autowired
    private UserEditor userEditor;
    @Autowired
    private Mail mail;

    @PostMapping("/registrationUser")
    public String save(User user,
            @RequestParam String psw_repeat,
             BindingResult result) {
        User findUser = userService.findByUsername(user.getUsername());
        if (findUser!=null) {
            return environment.getProperty("test_login_InDB");
        }

        // validation email
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String email = user.getEmail();
//        try {
//            email = br.readLine();
//        } catch (IOException e) {
//            System.out.println(Arrays.toString(e.getStackTrace()));
//        }
//        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//        Matcher m = pattern.matcher(email) ;
//
//        if(m.matches()) {
//            System.out.println(m.group());
//        }else {
//            return "wrong email";
//        }
        // end validation email


        //  відключив цей метод на період тестування!!!!!!

//        User userByEmail = userService.findByEmail(user.getEmail());
//        if(userByEmail!=null){
//            return environment.getProperty("test_email_InDB");
//        }

        userValidator.validate(user,result);
        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            String errorMessage = "";
            for (ObjectError error : allErrors) {
                errorMessage+=" "+environment.getProperty(error.getCode());
            }
            return errorMessage;
        }
        if(user.getPassword().equals(psw_repeat)) {     //перевірка на співпадіння паролів
            String randomKey = RandomStr.randomKey();   //Генерація і відправка ключа реєстрації на пошту клієнта
            user.setRandomKey(randomKey);
            userEditor.setValue(user);
            userService.addUser(user);
            String text = "Good day, " + user.getUsername() + " "
                    +"Activate account : <a href='http://localhost:8080/activate/"
                    + randomKey
                    + "'>Activate</a>";
            String subject = environment.getProperty("textForMailSender_String_subject");
            String email = user.getEmail();
//            for (int i = 0; i < 2; i++) {
                mail.sendMail(email,subject,text);
//            }
        } else {
            return environment.getProperty("matchPassword_registrationForm");
        }
        return "Go to the registration link from your mail";
    }
}

