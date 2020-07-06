package com.wlld.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wlld.naturalLanguage.Tokenizer;

/**
 * @param
 * @DATA
 * @Author LiDaPeng
 * @Description
 */
@Configuration
public class BeanMangerOnly {
    @Autowired
    private BeanManger bean;

    @Bean
    public Tokenizer tokenizer() {
        return new Tokenizer(bean.temple());
    }
}
