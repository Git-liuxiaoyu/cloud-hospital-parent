package com.example.drugservice.service.add;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


public interface IAddDrugOddCommandHandle {

    Long AddDrugOdd(AddDrugOddCommand command );

}
