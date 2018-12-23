package com.duongnv.spring.aop.service;

import lombok.extern.log4j.Log4j2;

@org.springframework.stereotype.Service
@Log4j2
public class GoodbyeService implements Service {
    @Override
    public void execute() {
       log.info("Good bye!");
    }
}
