package br.com.example.davidarchanjo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.davidarchanjo.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final KafkaProducer kafkaProducer;    

    @PostMapping
    public void send(@RequestBody String order) {
        kafkaProducer.send(order);
    }
}
