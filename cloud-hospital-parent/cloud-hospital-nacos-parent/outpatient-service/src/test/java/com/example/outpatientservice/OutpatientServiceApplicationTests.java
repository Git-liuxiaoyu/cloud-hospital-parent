package com.example.outpatientservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

//@SpringBootTest
class OutpatientServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void sort(){
        int[] arr = new int[]{5,8,2,99,23,124,42411,3125,12512,1241,1,24,124,12};
        int[] sort = sort(arr);
        StringBuilder str = new StringBuilder();
        for(int i=0;i<sort.length;i++){
            str.append(sort[i]+",");
        }
        System.out.println("{"+str.delete(str.length()-1,str.length())+"}");

    }

    @Test
    void insertSort(){
        int[] arr = new int[]{5,8,2,99,23,124,214,4214,421};
        for(int j = 0;j<arr.length;j++){
            //int j = i;
            int temp = arr[j];
            while (j!=0 && arr[j-1]>= temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
        System.out.println(Arrays.toString(arr));

    }

    @Test
    void insertSort2(){
//        int[] arr = new int[]{5,8,2,99,23,124,214,4214,421};
//        System.out.println(arr[arr.length-1]);
//        for(int i=arr.length-1;i>0;i--){
//            int temp = arr[i];
//            if ( arr[i] <arr[i-1]){
//                arr[i]= arr[i-1];
//                i--;
//                if ()
//            }
//
//        }
//        System.out.println(Arrays.toString(arr));

    }

    public int[] sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min =i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
//                    int temp =arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
                }
            }
//            int temp =arr[min];
//            arr[min] = arr[i];
//            arr[i] = temp;
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
            return  arr;
    }


}
