package ua.com.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.entity.User;
import ua.com.service.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindUserFromListOfBet {
@Autowired
        public UserService userService;

public List<User> userFromBet (int id_Lot, String userFromSession){

    List<User> userList = new ArrayList<>();
        List<Object[]>  objects = userService.listBetAndUserByLot_id(id_Lot);

        /*
        * take all unique username from bet
        * */
    List<String> collect = objects.stream()
            .map(objects1 -> (String) objects1[14])
            .distinct()
            .collect(Collectors.toList());

/*
* delete username witch is in session
* */
    List<String> list = collect.stream()
            .filter(n -> !n.equals(userFromSession))
            .collect(Collectors.toList());

    for (String s : list) {
        User userFromBet = userService.findByUsername(s);
        userList.add(userFromBet);
    }
    return userList;
}

}
