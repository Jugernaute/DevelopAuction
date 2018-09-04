//package ua.com.controllers.controllers_security;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import ua.com.dao.UserDao;
//import ua.com.editor.UserValidator;
//import ua.com.entity.User;
//
//import java.util.List;
//@PropertySource("classpath:validation.properties")
//@RestController
//public class MyRestController {
//
//
//        @Autowired
//        public Environment environment;
//        @Autowired
//        public UserDao userDao;
//        @Autowired
//        public UserValidator userValidator;
//
//
//        @PostMapping("/Save")
//        public List<User> userSave (@RequestBody User user,
//                                    BindingResult result,
//                                    Model model){
//            userValidator.validate(user,result);
//            String errors="";
//            if (result.hasErrors()) {
//                List<ObjectError> allErrors = result.getAllErrors();
//                for (ObjectError error : allErrors) {
//                    errors+=" "+environment.getProperty(error.getCode());
//                    System.out.println(errors);
//                }
//                model.addAttribute("errors",errors);
//                return userDao.findAll();
//            }
//            userDao.save(user);
//            return userDao.findAll();
//        }
//}
