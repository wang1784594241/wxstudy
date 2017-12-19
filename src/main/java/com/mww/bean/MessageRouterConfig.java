package com.mww.bean;

import com.mww.MessageRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/12/18.
 */
@Configuration
public class MessageRouterConfig {

    @Bean
    MessageRouter messageRoute() {
        return new MessageRouter();
    }
}
