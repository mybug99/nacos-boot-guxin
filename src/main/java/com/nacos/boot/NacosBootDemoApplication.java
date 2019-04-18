package com.nacos.boot;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@NacosPropertySource(dataId = "nacos-boot", autoRefreshed = true)
public class NacosBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosBootDemoApplication.class, args);
    }

    @RestController
    class HeyController {
        @NacosValue(value = "${hey}", autoRefreshed = true)
        private String hey;

        @RequestMapping("/hey")
        public String hey() {
            return hey;
        }

    }
}
