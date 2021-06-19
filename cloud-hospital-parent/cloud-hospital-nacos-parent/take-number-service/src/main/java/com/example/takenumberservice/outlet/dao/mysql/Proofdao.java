package com.example.takenumberservice.outlet.dao.mysql;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public interface Proofdao {

    int findorderNum();//查询最大排队数

}
