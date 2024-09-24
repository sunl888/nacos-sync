package com.sunl888.nacossync.controller;

import com.sunl888.nacossync.client.TestWebServiceRemote;
import com.sunl888.nacossync.config.AppConfig;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author sunl888
 * @date 2024/9/24
 */
@Slf4j
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Resource
    private AppConfig appConfig;

    @Resource
    private TestWebServiceRemote testWebServiceRemote;

    @GetMapping
    public ResponseEntity<Void> getConfig() {
        log.info("当前值:{}", appConfig.getName());
        log.info("从webService获取当前值:{}", testWebServiceRemote.getConfig(""));
        return ResponseEntity.ok().build();
    }

}
