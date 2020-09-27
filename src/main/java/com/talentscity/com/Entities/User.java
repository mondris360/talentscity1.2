package com.talentscity.com.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="users")
// users table
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private BigInteger userID;
    private String oauthUserId;
    private String firstName;
    private  String lastName;
    @Column(unique =  true)
    private  String email;
    private String password;
    private String Role = "USER";
    private Timestamp dateCreated =  new Timestamp(System.currentTimeMillis());
    private Timestamp lastLogin =  new Timestamp(System.currentTimeMillis());

    // method to create a new user
    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email =  email;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles  = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(this.getRole()));
        return roles;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
