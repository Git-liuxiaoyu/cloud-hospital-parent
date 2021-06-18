package com.example.drugservice.service.instock;


public interface IInStockDrugCommandHandle {
   //添加新药品
   void addDrug(InStockDrugCommand command);
   //补药品
   void updateDrug(InStockDrugCommand command);

   //查询药品
   InStockDrugCommand getDrugByNameAndByLocation(String name,String location);


}
