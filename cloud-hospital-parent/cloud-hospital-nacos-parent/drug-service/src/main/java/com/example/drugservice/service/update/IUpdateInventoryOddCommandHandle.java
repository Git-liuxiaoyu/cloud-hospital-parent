package com.example.drugservice.service.update;

import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


public interface IUpdateInventoryOddCommandHandle {
    void UpdateById(UpdateInventoryOddCommand command);
}
