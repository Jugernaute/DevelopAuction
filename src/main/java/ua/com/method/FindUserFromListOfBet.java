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
    Object[] objects1 = objects.get(0);
    List<String> collect = objects.stream()
            .map(objects2 -> (String) objects2[15])
            .distinct()
            .collect(Collectors.toList());
//    Object[] objects1 = objects.get(0);
//    System.out.println(objects1.length);
//    for (Object o : objects1) {
//    System.out.println("length " + objects1.length);
//        System.out.println(objects1[15]+" >> "+objects1[18]);
//    for (Object o : objects1) {
//        System.out.println("-> " + o);
//    }
//    }
    /*
* delete username witch is in session
* */
//    for (String s : collect) {
//        System.out.println(">>>> "+ s);
//    }
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
