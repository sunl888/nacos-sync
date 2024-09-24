package com.sunl888.nacossync.webservice.impl;

import com.sunl888.nacossync.config.AppConfig;
import com.sunl888.nacossync.webservice.TestWebService;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author sunl888
 * @date 2024/9/24
 */
@WebService(
        serviceName = "testWebService",
        targetNamespace = "https://service.nacos.sync.sunl888.com/",
        endpointInterface = "com.sunl888.nacossync.webservice.TestWebService")
@Service
@Slf4j
public class TestWebServiceImpl implements TestWebService {
    @Resource
    private AppConfig appConfig;

    @Override
    public String getConfig(String request) {
        return appConfig.getName();
    }
}
