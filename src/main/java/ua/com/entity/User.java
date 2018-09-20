package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(unique = true)
    private String username;
    private String email;
    private String password;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;

    private String firstname;
    private String surname;
    private int userBalans;
    private String userPostAddress;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.PERSIST)
    private List<Product> listUserProduct;
@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.PERSIST)
    private List<Bet> listUserBet;

    public User() {
    }

    public User(String firstname, String surname, int userBalans, String userPostAddress) {
        this.firstname = firstname;
        this.surname = surname;
        this.userBalans = userBalans;
        this.userPostAddress = userPostAddress;
    }

    public User(String firstname, String surname, int userBalans, String userPostAddress, List<Product> listUserProduct, List<Bet> listUserBet) {
        this.firstname = firstname;
        this.surname = surname;
        this.userBalans = userBalans;
        this.userPostAddress = userPostAddress;
        this.listUserProduct = listUserProduct;
        this.listUserBet = listUserBet;
    }

    public User(String username, String email, String password, String phone, Role role, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, String firstname, String surname, int userBalans, String userPostAddress, List<Product> listUserProduct, List<Bet> listUserBet) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.firstname = firstname;
        this.surname = surname;
        this.userBalans = userBalans;
        this.userPostAddress = userPostAddress;
        this.listUserProduct = listUserProduct;
        this.listUserBet = listUserBet;
    }

    public String getFirstname() {
        return firstname;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getUserBalans() {
        return userBalans;
    }

    public User setUserBalans(int userBalans) {
        this.userBalans = userBalans;
        return this;
    }

    public String getUserPostAddress() {
        return userPostAddress;
    }

    public User setUserPostAddress(String userPostAddress) {
        this.userPostAddress = userPostAddress;
        return this;
    }

    public List<Product> getListUserProduct() {
        return listUserProduct;
    }

    public User setListUserProduct(List<Product> listUserProduct) {
        this.listUserProduct = listUserProduct;
        return this;
    }

    public List<Bet> getListUserBet() {
        return listUserBet;
    }

    public User setListUserBet(List<Bet> listUserBet) {
        this.listUserBet = listUserBet;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                isAccountNonExpired == user.isAccountNonExpired &&
                isAccountNonLocked == user.isAccountNonLocked &&
                isCredentialsNonExpired == user.isCredentialsNonExpired &&
                isEnabled == user.isEnabled &&
                userBalans == user.userBalans &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone) &&
                role == user.role &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(userPostAddress, user.userPostAddress) &&
                Objects.equals(listUserProduct, user.listUserProduct) &&
                Objects.equals(listUserBet, user.listUserBet);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, username, email, password, phone, role, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled, firstname, surname, userBalans, userPostAddress, listUserProduct, listUserBet);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
