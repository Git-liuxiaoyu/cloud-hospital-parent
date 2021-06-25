package com.example.drugservice.adapt.Exception;

public class DrugNotFoundException extends RuntimeException{
    public DrugNotFoundException(){
        super("药房不存在");
    }
    public DrugNotFoundException(Long drugId) {
        super(String.format("部门[%s]不存在", drugId));
    }
}
