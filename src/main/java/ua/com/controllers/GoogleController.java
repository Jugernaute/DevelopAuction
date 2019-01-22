package ua.com.controllers;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import ua.com.entity.User;
import ua.com.service.user.UserService;
import ua.com.service.userconnect.ConnectionSingUpImpl;
import ua.com.service.userconnect.UserConnectService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("googleToken")
public class GoogleController {

    @Autowired
    Environment env;
    @Autowired
    UserService userService;
    @Autowired
    UserConnectService userConnectService;
    @Autowired
    ConnectionSingUpImpl connectionSingUp;
    @Autowired
    UsersConnectionRepository repository;


    @PostMapping("/goog/login")
    public void googleLogin(HttpServletResponse response) throws IOException {
        GoogleConnectionFactory factory = new GoogleConnectionFactory(
                env.getProperty("google.app.id"),
                env.getProperty("google.app.secret")
        );



        OAuth2Parameters parameters = new OAuth2Parameters();
        parameters.setRedirectUri("http://localhost:8080/auth/google");
        parameters.setScope("email");

        OAuth2Operations authOperations = factory.getOAuthOperations();
        String authorizeUrl = authOperations.buildAuthorizeUrl(parameters);
        response.sendRedirect(authorizeUrl);


        System.out.println(authorizeUrl);
        System.out.println("---------");
        System.out.println(response.toString());

    }


    @GetMapping("/auth/google")
    public String googCallback(@RequestParam("code") String code, Model model, WebRequest request) throws IOException {
        GoogleConnectionFactory factory = new GoogleConnectionFactory(
                env.getProperty("google.app.id"),
                env.getProperty("google.app.secret"));
        User user = (User) request.getUserPrincipal();
        OAuth2Operations authOperations = factory.getOAuthOperations();
        AccessGrant accessGrant = authOperations.exchangeForAccess(code, "http://localhost:8080/auth/google", null);
        Connection<Google> connection = factory.createConnection(accessGrant);
        String token = accessGrant.getAccessToken();
        Google google = connection.getApi();
        if (google.isAuthorized()) {
            String id = connectionSingUp.execute(connection);
//         PagedList<Post> feed = facebook.feedOperations().getFeed();
//            List<String> images = feed.stream().map(post -> post.getPicture()).collect(Collectors.toList());
//            model.addAttribute("images", images);

            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            //User user = userService.findByUsername(name);
            //System.out.println(name);
            //System.out.println(id);
            return "cabinet";//login, ok,
        } else {
            return "redirect:/goog/login";
        }
    }

    @PostMapping("/protected1")
    public String protect() {
        return "cabinet";
    }

}


