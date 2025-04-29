package com.test.basic.config;

import com.test.basic.board.TagDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    //<bean class="com.test.basic.board.TagDAO"></bean>
    @Bean
    public TagDAO getTagDAO(){
        return new TagDAO();
    }
}
