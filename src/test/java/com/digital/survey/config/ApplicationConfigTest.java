package com.digital.survey.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.SyncTaskExecutor;

/**
 * Application config for tests
 * 
 * @since 1.0
 */
@Configuration
public class ApplicationConfigTest {

    /**
     * This bean is responsible for {@link Executor} used for async tasks
     * 
     * @return {@link Executor}
     */
    @Bean
    @Primary
    public Executor threadPoolTaskExecutor() {
        SyncTaskExecutor executor = new SyncTaskExecutor();
        return executor;
    }
}
