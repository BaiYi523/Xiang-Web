package com.xiang.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Pattern;

@SpringBootTest
class ApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        String in="123.456";
        Pattern pattern2 = Pattern.compile("^[-\\+]?[\\d]+[.][\\d]+$");
        System.out.println(pattern2.matcher(in).matches());

    }

}
