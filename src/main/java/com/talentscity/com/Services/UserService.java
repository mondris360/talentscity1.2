package com.talentscity.com.Services;

import com.talentscity.com.Entities.User;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public interface UserService {
    User createUser(User user);
    User login(User user);
    User getUserById(BigInteger userID);
    User findUserById(BigInteger userID);
    User findUserEmail(String email);
    User findUserByOauthID(String userOauthID);
}
