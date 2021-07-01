package com.example.payservice.outlet.cliten.pharmacy.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class ExampleQueryDrugOddCommand {
private String no;
private Long drugOddId;


}
