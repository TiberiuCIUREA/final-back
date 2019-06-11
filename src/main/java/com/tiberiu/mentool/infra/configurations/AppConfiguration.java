package com.tiberiu.mentool.infra.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories(basePackages = AppConfiguration.BASE_PACKAGES)
@ComponentScan(basePackages = AppConfiguration.BASE_PACKAGES)
public class AppConfiguration {
    static final String BASE_PACKAGES = "com.tiberiu.mentool";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
