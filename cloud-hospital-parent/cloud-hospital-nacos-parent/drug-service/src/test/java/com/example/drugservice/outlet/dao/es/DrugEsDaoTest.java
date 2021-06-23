package com.example.drugservice.outlet.dao.es;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DrugEsDaoTest {

    @Autowired
    private DrugEsDao esDao;

    @Test
    void findAll() {
        esDao.deleteAll();
    }
}