package com.talentscity.com.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private BigInteger userID;
    private String firstName;
    private  String lastName;
    private  String email;
}
