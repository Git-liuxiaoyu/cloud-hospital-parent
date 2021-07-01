package com.example.takenumberservice;

import com.example.takenumberservice.adapter.RegisterAdapter;
import com.example.takenumberservice.outlet.client.register.pojo.QueryGetByIdVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
//@SpringBootTest
class TakeNumberServiceApplicationTests {
    @Autowired
    private RegisterAdapter registerAdapter;

    @Test
    void contextLoads() {
        QueryGetByIdVo byRegId = registerAdapter.findByRegId(11L);
        System.out.println(byRegId);

    }

    @Test//选择
    public void array(){
        int[]array = {10,5,4,8,9,2,1,3,6,7};
        for(int i = 0;i<array.length-1;i++){
            int min = i;
            for(int j = i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }
            int x = array[i];
            array[i] = array[min];
            array[min] = x;
        }
        System.out.println(Arrays.toString(array));

    }

    @Test//插入
    public void array2(){
        int[]array = {10,5,4,8,9,2,1,3,6,7};

        for(int i = 1;i<array.length;i++){
            int x = array[i];
            int j = i;
            for(;j>0 && array[j-1]>x;j--){
                array[j] = array[j-1];
            }
            array[j] = x;
        }
        System.out.println(Arrays.toString(array));
    }



}
