//package ua.com.service.userconnect;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.social.connect.Connection;
//import org.springframework.social.connect.ConnectionSignUp;
//import org.springframework.social.connect.UserProfile;
//import org.springframework.social.google.api.Google;
//import org.springframework.social.google.api.plus.Person;
//import org.springframework.stereotype.Service;
//import ua.com.entity.Role;
//import ua.com.entity.User;
//import ua.com.entity.UserConnection;
//import ua.com.service.user.UserService;
//
//@Service
//public class ConnectionSingUpImpl implements ConnectionSignUp {
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    UserConnectService userConnectService;
//
//    @Override
//    public String execute(Connection<?> connection) {
//
//        String userIdSocial = "";
//        UserConnection connectionData = new UserConnection(connection.createData());
//        UserConnection userConnectionData = userConnectService.findByProviderUserId(connectionData.getProviderUserId());
//        User user;
//        if (userConnectionData == null){
//            //Google google = (Google)connection.getApi();
//            //Person person = google.plusOperations().getGoogleProfile();
//            org.springframework.social.connect.UserProfile userProfile = connection.fetchUserProfile();
//           // UserProfile userProfile = connection.fetchUserProfile();
//            user = new User(userProfile.getId(),
//                    userProfile.getUsername(),
//                    null, userProfile.getEmail(), Role.ROLE_USER, connectionData);
//            connectionData.setUser(user);
//            userService.save(user);
//            userConnectService.save(connectionData);
//            userIdSocial = user.getUserIdSocial();
//        } else {
//            user = userService.findByUserConnectionIn(userConnectionData);
//        }
//        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        return userIdSocial;
//    }
//}
