package ua.com.controllers.controllers_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.security.config.CustomerValidator;
import ua.com.security.editor.CustomerEditor;
import ua.com.security.entity.Customer;
import ua.com.security.services.CustomerService;


import java.util.List;

@Controller
@PropertySource("classpath:validation.properties")
public class MainController {

    @Autowired
    private Environment environment;

    @GetMapping("/login")
        public String login  (){
            return "home" ;
        }

    @GetMapping("/")
        public String start (){
            return "home" ;
        }

    @PostMapping("/ok")
        public String ok (){
            return "success" ;
        }

    @GetMapping("/home")
        public String home (){
            return "home" ;
        }

     @GetMapping("/go_login")
         public String gologin (){
             return "home" ;
         }

    @GetMapping("/error")
        public String error (){
            return "error" ;
        }

    @GetMapping("/registration")
        public String registration (){
            return "registration" ;
        }


        @Autowired
        private CustomerService customerService;
//        @Autowired
//        private PasswordEncoder passwordEncoder;
        @Autowired
        private CustomerEditor customerEditor;
        @Autowired
        CustomerValidator customerValidator;
    @PostMapping("/save")
        public String  save (Customer customer,
                             BindingResult result,
                             Model model){

        customerValidator.validate(customer,result);
        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            String errorMessage = "";
            for (ObjectError error : allErrors) {
                errorMessage+=" "+environment.getProperty(error.getCode());

            }
              model.addAttribute("error",errorMessage);

            return "registration";
        }
        customerEditor.setValue(customer);
        customerService.save(customer);
        return "home";
        }

}
