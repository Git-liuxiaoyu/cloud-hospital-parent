package com.example.takenumberservice.outlet.dao.mysql;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


public interface Proofdao {
    int findorderNum();//根据挂号id查询取票信息

}
