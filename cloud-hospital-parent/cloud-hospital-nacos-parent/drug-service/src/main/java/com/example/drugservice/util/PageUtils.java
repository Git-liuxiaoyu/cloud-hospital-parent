package com.example.drugservice.util;


import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

public class PageUtils<T> {

    public  PageInfo<T> getPageInfo( Integer pageIndex,Integer pageSize,List<T> drugList){
        //创建一个pageInfo对象
        PageInfo<T> pageInfo=new PageInfo<T>();
        //创建分页集合
        List<T> drugPageList=new ArrayList<>();
        //分页

        //判断本次分页数据的循环满不满pageSize个
        //如果满，循环pageSize次
        if(drugList.size()>((pageIndex)*pageSize)){
            for(int i=(pageIndex-1)*pageSize;i<=((pageIndex)*pageSize-1);i++){
                //从查到的集合中取出Drug对象
                T t= drugList.get(i);
                //添加到要返回的集合中
                drugPageList.add(t);

            }
            //如果不满，循环从(pageIndex-1)*pageSize到总数量个
        }else{
            for(int i=(pageIndex-1)*pageSize;i<=drugList.size()-1;i++){
                //从查到的集合中取出Drug对象
                T t= drugList.get(i);
                //添加到要返回的集合中
                drugPageList.add(t);
            }
        }

        //分页对象的总记录数为查询到的集合的size
        pageInfo.setTotal(drugList.size());
        pageInfo.setPageNum(pageIndex);
        pageInfo.setPageSize(pageSize);
        pageInfo.setList(drugPageList);

        return pageInfo;
    }


}
