package com.sunl888.nacossync.config;

import com.sunl888.nacossync.client.TestWebServiceRemote;
import com.sunl888.nacossync.webservice.TestWebService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 *
 * @author sunl888
 * @date 2024/9/24
 */
@Configuration
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean<CXFServlet> cxfServletServletRegistrationBean() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/ws/*");
    }

    @Bean
    public Endpoint testEndpoint(Bus bus, TestWebService testWebService) {
        Endpoint endpoint = new EndpointImpl(bus, testWebService);
        endpoint.publish("/testWebService");
        return endpoint;
    }

    @Bean
    public TestWebServiceRemote testWebServiceRemote() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:8088/ws/testWebService?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(TestWebServiceRemote.class);
        return jaxWsProxyFactoryBean.create(TestWebServiceRemote.class);
    }
}
