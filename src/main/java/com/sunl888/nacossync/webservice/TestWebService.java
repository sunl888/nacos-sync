package com.sunl888.nacossync.webservice;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 * 描述
 *
 * @author sunl888
 * @date 2024/9/24
 */
@WebService(targetNamespace = "https://service.nacos.sync.sunl888.com/")
public interface TestWebService {

    String getConfig(@WebParam(name = "request") String request);
}
