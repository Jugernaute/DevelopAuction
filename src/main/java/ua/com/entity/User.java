package ua.com.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
    private String randomKey;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;
    private String firstNameUser;
    private String surNameUser;
    private int userBalance;
    private String userPostAddress;

    @Enumerated(EnumType.STRING)
    @ElementCollection(
            targetClass = TypeUser.class,
            fetch = FetchType.EAGER)
    @CollectionTable(name = "type_user",
            joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "type")
    private Set<TypeUser> typeOfUser;


    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "userOwner")
    private List<Product> productListOfUser;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "user")
    private List<Bet>listUserBet;


    public User(String firstNameUser, String surNameUser, int userBalance, String userPostAddress) {
        this.firstNameUser = firstNameUser;
        this.surNameUser = surNameUser;
        this.userBalance = userBalance;
        this.userPostAddress = userPostAddress;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    public String getRandomKey() {
        return randomKey;
    }

    public void setRandomKey(String randomKey) {
        this.randomKey = randomKey;
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



    public User() {
    }

    public User(String username, int userBalance) {
        this.username = username;
        this.userBalance = userBalance;
    }

    public User(String username, int userBalance,
                List<Product> productListOfUser,
                List<Bet> listUserBet) {
        this.username = username;
        this.userBalance = userBalance;
        this.productListOfUser = productListOfUser;
        this.listUserBet = listUserBet;
    }

    public String getFirstNameUser() {
        return firstNameUser;
    }

    public void setFirstNameUser(String firstNameUser) {
        this.firstNameUser = firstNameUser;
    }

    public String getSurNameUser() {
        return surNameUser;
    }

    public void setSurNameUser(String surNameUser) {
        this.surNameUser = surNameUser;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }

    public String getUserPostAddress() {
        return userPostAddress;
    }

    public void setUserPostAddress(String userPostAddress) {
        this.userPostAddress = userPostAddress;
    }

    public Set<TypeUser> getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(Set<TypeUser> typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public List<Product> getProductListOfUser() {
        return productListOfUser;
    }

    public void setProductListOfUser(List<Product> productListOfUser) {
        this.productListOfUser = productListOfUser;
    }

    public List<Bet> getListUserBet() {
        return listUserBet;
    }

    public void setListUserBet(List<Bet> listUserBet) {
        this.listUserBet = listUserBet;
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
                userBalance == user.userBalance &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone) &&
                role == user.role &&
                Objects.equals(firstNameUser, user.firstNameUser) &&
                Objects.equals(surNameUser, user.surNameUser) &&
                Objects.equals(userPostAddress, user.userPostAddress) &&
                Objects.equals(productListOfUser, user.productListOfUser) &&
                Objects.equals(listUserBet, user.listUserBet);
    }



    @Override
    public int hashCode() {

        return Objects.hash(userId, username, email, password, phone, role, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled, firstNameUser, surNameUser, userBalance, userPostAddress);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstNameUser='" + firstNameUser + '\'' +
                ", surNameUser='" + surNameUser + '\'' +
                ", userBalance=" + userBalance +
                ", userPostAddress='" + userPostAddress + '\'' +
                '}';
    }
}
