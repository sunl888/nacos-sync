package com.sunl888.nacossync.client;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

/**
 * 描述
 *
 * @author sunl888
 * @date 2024/9/24
 */
@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService(targetNamespace = "https://service.nacos.sync.sunl888.com/", name = "testWebService")
public interface TestWebServiceRemote {

    @WebMethod
    @WebResult(partName = "return")
    String getConfig(@WebParam(name = "request") String request);
}
