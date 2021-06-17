package com.example.workerservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
class WorkerServiceApplicationTests {

    @Test
    void contextLoads() {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");


        String format = simpleDateFormat.format(new Date());


        System.out.println(format+ (long) (Math.random() * 1000000));


    }

}
