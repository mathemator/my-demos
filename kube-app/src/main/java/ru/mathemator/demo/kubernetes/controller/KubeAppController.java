package ru.mathemator.demo.kubernetes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class KubeAppController {

    @GetMapping("/")
    public String home() throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        return "Hello from pod: " + hostname;
    }
}
