package com.sorry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sorry.service.Impl.CrawlerInsertService;

@Configuration
public class ApplicationConfig {

    public @Bean CrawlerInsertService getCrawlerInsertService() {
        return new CrawlerInsertService();
    }
}
