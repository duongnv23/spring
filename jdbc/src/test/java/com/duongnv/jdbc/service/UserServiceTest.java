package com.duongnv.jdbc.service;

import com.duongnv.jdbc.config.JdbcConfiguration;
import com.duongnv.jdbc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class )
@JdbcTest
@ContextConfiguration(classes = {JdbcConfiguration.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void testFindByUserName(){

        User duongnv = service.findByUsername("duongnv");
        assertNotNull(duongnv);

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void testFindByUserNameNotFound(){
        User unknown = service.findByUsername("unknown");
    }
}