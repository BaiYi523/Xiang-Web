package com.xiang.mapper;

import com.xiang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserByQq(BigInteger id);

    User querUserName(String username);

    User queryUserById(String username,String pwd);
    User queryUserById2(BigInteger username,String pwd);

    int updatePwd(BigInteger qq,String userPwd);

    int addUser(User user);

    int updateUser(User user);

    int deteUser(int id);
}
