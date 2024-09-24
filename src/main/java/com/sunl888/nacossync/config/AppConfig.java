package com.sunl888.nacossync.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 *
 * @author sunl888
 * @date 2024/9/24
 */
@Data
@RefreshScope
@Configuration
public class AppConfig {

    @Value("${name:}")
    private String name;
}
