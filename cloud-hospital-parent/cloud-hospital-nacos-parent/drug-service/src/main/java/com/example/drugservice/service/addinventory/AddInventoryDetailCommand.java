package com.example.drugservice.service.addinventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInventoryDetailCommand {

    private String lossReason;

    private String lossdrugno;

    private Integer lossdrugnum;


}
