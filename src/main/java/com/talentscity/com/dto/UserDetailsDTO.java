//package com.talentscity.com.dto;
//
//import com.talentscity.com.Entities.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.math.Long;
//import java.util.Collection;
//
//public class UserDetailsDTO  implements UserDetails {
//    private Long userId;
//    private String username;
//    private String password;
//
//
//    public UserDetailsDTO(User user){
//        this.userId =  Long.valueOf(user.getUserID());
//        this.username = user.getEmail();
//        this.
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
