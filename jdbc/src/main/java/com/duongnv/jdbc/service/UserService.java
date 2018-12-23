package com.duongnv.jdbc.service;

import com.duongnv.jdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserService {

    private JdbcTemplate template;

    @Autowired
    public UserService(JdbcTemplate template) {
        this.template = template;
    }

    private static User extractData(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        return user;
    }

    public User findByUsername(String username) {
        return template.queryForObject("select id, username from user where username=?", new String[]{username}, UserService::extractData);
    }

}
