package com.example.drugservice.service.outstock;

public interface IOutStockDrugCommandHandle {
    //根据药品编号 减库存
    public void UpDateDrugByNo(String no,Integer num);
}
