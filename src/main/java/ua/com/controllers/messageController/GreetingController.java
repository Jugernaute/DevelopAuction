package ua.com.controllers.messageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.entity.InputMessage;
import ua.com.entity.OutputMessage;
import ua.com.entity.User;
import ua.com.service.user.UserService;

@Controller
public class GreetingController {

    @Autowired
    private UserService userService;

    @GetMapping("/ws")
    public String ws(){
        return "ws";
    }

    @MessageMapping("/helloPoint")
    @SendTo("/topic/greetings")
    public OutputMessage greeting(InputMessage inputMessage){
//        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        String messageName = inputMessage.getName();
        OutputMessage responseMessage = new OutputMessage("hello " + messageName);
        System.out.println("dddddfffffff" + responseMessage );
        return responseMessage;
    }
}
