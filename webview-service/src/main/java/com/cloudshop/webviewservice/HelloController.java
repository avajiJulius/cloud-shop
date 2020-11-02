package com.cloudshop.webviewservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    private HelloClient client;

    @Autowired
    public void setClient(HelloClient client) {
        this.client = client;
    }

    @GetMapping("/get-hello")
    public String hello(Model model) {
        String result = client.hello();
        model.addAttribute("hello", result);
        return "hello";
    }
}
