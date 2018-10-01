package ua.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.editor.UserValidator;
import ua.com.editor.UserEditor;
import ua.com.entity.*;
import ua.com.service.user.UserService;


import java.util.List;

@Controller
@PropertySource("classpath:validation.properties")
public class MainController {

    @Autowired
    private Environment environment;

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

    @GetMapping("/error")
        public String error (){
            return "error" ;
        }



        @Autowired
        private UserService userService;
        @Autowired
        private UserEditor userEditor;
        @Autowired
        UserValidator userValidator;

    @PostMapping("/save")
        public String  save (User user,
//                             @RequestParam String psw_repeat,
                             BindingResult result,
                             Model model){

        userValidator.validate(user,result);
        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            String errorMessage = "";
            for (ObjectError error : allErrors) {
                errorMessage+=" "+environment.getProperty(error.getCode());
            }
            model.addAttribute("error",errorMessage);

            return "home";
        }

        userEditor.setValue(user);
        userService.addUser(user);
        return "home";
        }


        /////////////////////////////////////

    @GetMapping("/save")
    public String home(Model model){
        return "save";
    }

    @GetMapping("/delete")
    public String delete(Model model){
        return "delete";
    }

    @GetMapping("/restp")
    public String restp(){
        return "restp";
    }

    @ModelAttribute("userModel")
    public User user(){
        return new User();
    }
}
