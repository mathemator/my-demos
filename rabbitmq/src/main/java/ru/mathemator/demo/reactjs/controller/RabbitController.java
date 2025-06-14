package ru.mathemator.demo.reactjs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mathemator.demo.reactjs.rabbit.RabbitMqProducer;

@RestController
public class RabbitController {

    @Autowired
    private RabbitMqProducer producer;

    @GetMapping("/send")
    public void sendTestMessage() {
        producer.sendMessage("Hello, RabbitMQ!");
    }



}
