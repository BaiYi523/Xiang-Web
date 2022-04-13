package com.xiang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private int id;
  private BigInteger qq;
  private String userName;
  private int userSex;
  private int userAge;
  private String userPwd;
  private String userHobby;
  private String userRegion;
  private Date registrationDate;
  private int administrator;

}
