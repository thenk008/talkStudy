package com.wlld.bean;

import com.wlld.entity.MyTree;
import com.wlld.entity.Response;
import com.wlld.entity.SentenceSql;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.wlld.naturalLanguage.Talk;
import org.wlld.naturalLanguage.WordTemple;

/**
 * @param
 * @DATA
 * @Author LiDaPeng
 * @Description
 */
@Configuration
@Scope("prototype")
public class BeanManger {
    @Bean
    public Response response() {//统一响应消息体
        return new Response();
    }

    @Bean
    public MyTree myTree() {//层级结构
        return new MyTree();
    }

    @Bean
    public WordTemple temple() {//rf初始化参数
        WordTemple wordTemple = new WordTemple();
        wordTemple.setTreeNub(9);//设置森林当中树木的数量
        wordTemple.setGarbageTh(0.5);//设置可识别阈值
        wordTemple.setTrustPunishment(0.1);//信任惩罚 惩罚连乘
        wordTemple.setTrustTh(0.1);//信任阈值  阈值乘树的个数
        return wordTemple;
    }

    @Bean
    public SentenceSql sentenceSql() {//语句变化
        return new SentenceSql();
    }
}
