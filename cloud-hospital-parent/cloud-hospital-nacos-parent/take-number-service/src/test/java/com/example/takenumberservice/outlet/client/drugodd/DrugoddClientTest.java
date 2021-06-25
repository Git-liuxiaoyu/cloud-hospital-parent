package com.example.takenumberservice.outlet.client.drugodd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DrugoddClientTest {

    @Autowired
    private DrugoddClient client;

    @Autowired
    private RestTemplate template;

    @Test
    public void demo() throws InterruptedException {
        // System.out.println(template.postForEntity("http://drug-service/drugOdd/byNo/YF0004",null, String.class));
        System.out.println(client.findByYFNo("YF0004"));
        TimeUnit.SECONDS.sleep(3);
        System.out.println(client.findByYFNo("YF0004"));

    }
}