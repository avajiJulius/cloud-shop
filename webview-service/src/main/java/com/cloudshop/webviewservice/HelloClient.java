package com.cloudshop.webviewservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("client")
public interface HelloClient {
    @GetMapping("/hello")
    String hello();
}
