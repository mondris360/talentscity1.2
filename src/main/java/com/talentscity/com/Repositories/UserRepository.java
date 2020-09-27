package com.talentscity.com.Repositories;

import com.talentscity.com.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {
    User save(User user);
    User findUserByEmail(String email);
    User findUserByUserID(BigInteger userID);
//    User findUserByUserID(Long userID);
    User findByOauthUserId(String userOauthID);
}
