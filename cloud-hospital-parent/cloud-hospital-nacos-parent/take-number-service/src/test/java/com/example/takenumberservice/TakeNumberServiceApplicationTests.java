package com.example.takenumberservice;

import com.example.takenumberservice.adapter.RegisterAdapter;
import com.example.takenumberservice.outlet.client.register.pojo.QueryGetByIdVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
@SpringBootTest
class TakeNumberServiceApplicationTests {
    @Autowired
    private RegisterAdapter registerAdapter;

    @Test
    void contextLoads() {
        QueryGetByIdVo byRegId = registerAdapter.findByRegId(11L);
        System.out.println(byRegId);

    }

}
