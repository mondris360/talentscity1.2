package com.talentscity.com.Services;

import com.talentscity.com.Entities.User;
import com.talentscity.com.Services.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User getUser =  userServiceImpl.findUserEmail(email);
        System.out.println("User Record" +  getUser);
        if (getUser == null) {
            throw new UsernameNotFoundException("Invalid Email Address" + email);
        }
        return getUser;
    }
}
