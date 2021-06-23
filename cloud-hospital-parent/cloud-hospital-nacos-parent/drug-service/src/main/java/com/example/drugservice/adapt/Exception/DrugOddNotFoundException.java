package com.example.drugservice.adapt.Exception;

public class DrugOddNotFoundException extends RuntimeException{
    public DrugOddNotFoundException(){
        super("药房不存在");
    }
    public DrugOddNotFoundException(Long departmentId) {
        super(String.format("部门[%s]不存在", departmentId));
    }
}
