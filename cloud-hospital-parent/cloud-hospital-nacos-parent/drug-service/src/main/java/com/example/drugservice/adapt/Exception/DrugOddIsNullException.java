package com.example.drugservice.adapt.Exception;

public class DrugOddIsNullException extends RuntimeException{
    public DrugOddIsNullException(){
        super("查询的对象为空,参数不对");
    }
    public DrugOddIsNullException(String no) {
        super(String.format("药品单[%s]不存在", no));
    }
}
