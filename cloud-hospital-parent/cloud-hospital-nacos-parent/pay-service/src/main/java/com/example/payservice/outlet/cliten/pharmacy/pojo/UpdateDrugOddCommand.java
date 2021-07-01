package com.example.payservice.outlet.cliten.pharmacy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDrugOddCommand {
    private Long id;
    private String status;

}
