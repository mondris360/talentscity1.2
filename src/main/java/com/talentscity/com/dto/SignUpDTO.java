package com.talentscity.com.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

    private BigInteger userID;
    private String firstName;
    private  String lastName;
    private  String email;
    private String password;
    private  String confirmPass;

}
