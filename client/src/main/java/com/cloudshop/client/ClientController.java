package com.cloudshop.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public interface ClientController {
    @GetMapping("/hello")
    String hello();
}
