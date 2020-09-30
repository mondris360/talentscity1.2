package com.talentscity.com.Services.ServiceImpl;

import com.talentscity.com.Entities.User;
import com.talentscity.com.Repositories.UserRepository;
import com.talentscity.com.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.HashPassword;

import java.math.BigInteger;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    // method to create a new user
    public User createUser(User user) {
        // check if the user already exists
        User getUser =  userRepository.findUserByEmail(user.getUsername());
        // if the user already exists
        if (getUser != null){
            return null;
        }

        return userRepository.save(user);
    }

    @Override
    // method to valid user login
    public User login(User user) {
        User getUser =  userRepository.findUserByEmail(user.getUsername());
        if (getUser == null){
            return null;
        }
        // validate the user encrypted password
        String plainPass =  user.getPassword();
        String encryptedPass =  getUser.getPassword();

        // validate the encrypted password
        boolean isValid =  HashPassword.validateEncryptedPass(plainPass, encryptedPass);
        if (!isValid){
            return null;
        }

        return  getUser;
    }

    @Override
    public User getUserById(BigInteger userID) {
        return  userRepository.findUserByUserID(userID);
    }

    @Override
    public User findUserById(BigInteger userID) {
        return userRepository.findUserByUserID(userID);
    }

    @Override
    // retrieve user record by email
    public User findUserEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserByOauthID(String userOauthID) {
        return userRepository.findByOauthUserId(userOauthID);
    }


    // method to get user by id

}
