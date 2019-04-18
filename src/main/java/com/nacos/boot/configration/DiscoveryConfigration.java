package com.nacos.boot.configration;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Scanner;


@Configuration
public class DiscoveryConfigration {

    @NacosInjected
    private NamingService namingService;
    @Value("${spring.application.name}")
    String ServiceName;
    @Value("${server.port}")
    int port;

    @PostConstruct
    public void get() throws NacosException {
        namingService.registerInstance(ServiceName, "127.0.0.1", port);
    }
}
