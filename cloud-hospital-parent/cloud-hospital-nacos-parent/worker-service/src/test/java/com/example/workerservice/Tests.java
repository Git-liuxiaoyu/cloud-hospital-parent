package com.example.workerservice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

//@SpringBootTest
//@RunWith(SpringRunner.class)
class Tests {

    @Test
    public void doubleSort() {

        /* 声明一个数组 */
        Integer[] arr = new Integer[20];
        /* 赋值 */
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        /* 打印排序前数组 */
        System.out.println("BEFORE -> " + Arrays.toString(arr) + " -> " + arr.length);

        /* 复制一个数组 */
        Integer[] temp = new Integer[arr.length];

        /* 排序 */
        sort(arr, 0, arr.length - 1, temp);

        /* 打印排序前数组 */
        System.out.println("AFTER -> " + Arrays.toString(temp) + " -> " + temp.length);

    }

    /**
     * @param arr   被排序的数组
     * @param left  左边界索引
     * @param right 有边界索引
     */
    public void sort(Integer[] arr, Integer left, Integer right, Integer[] temp) {
        /* 编写停止递归条件 */
        if (left >= right) {
            return;
        }

        /* 计算中间 */
        Integer mid = (left + right) / 2;

        /* 给左边部分排序 */
        sort(arr, left, mid, temp);
        /* 给右边部分排序 */
        sort(arr, mid + 1, right, temp);
        /* 交换位置 */
        merge2(arr, left, mid, right, temp);
    }

    private void merge(Integer[] arr, Integer left, Integer mid, Integer right, Integer[] temp) {

        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }

    }

    private void merge2(Integer[] arr, Integer left, Integer mid, Integer right, Integer[] temp) {

        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                temp[k] = arr[j++];
            } else if (j > right) {
                temp[k] = arr[i++];
            } else if (arr[i] < arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
        }

        while (left <= right) {
            arr[left] = temp[left++];
        }

    }

}
