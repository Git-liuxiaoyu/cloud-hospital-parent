package com.example.workerservice;

import com.example.workerservice.inlet.web.vo.DepartmentVo;
import com.example.workerservice.outlet.dao.es.DepartmentEsPoDao;
import com.example.workerservice.outlet.dao.es.DoctorRotaEsPoDao;
import com.example.workerservice.outlet.dao.es.PositionEsPoDao;
import com.example.workerservice.outlet.dao.es.WorkerInfoEsPoDao;
import com.example.workerservice.outlet.dao.es.po.DepartmentEsPo;
import com.example.workerservice.outlet.dao.es.po.DoctorRotaEsPo;
import com.example.workerservice.outlet.dao.es.po.PositionEsPo;
import com.example.workerservice.outlet.dao.es.po.WorkerInfoEsPo;
import com.example.workerservice.outlet.dao.mysql.DepartmentPoDao;
import com.example.workerservice.outlet.dao.mysql.DoctorRotaPoDao;
import com.example.workerservice.outlet.dao.mysql.PositionPoDao;
import com.example.workerservice.outlet.dao.mysql.WorkerInfoPoDao;
import com.example.workerservice.outlet.dao.mysql.po.*;
import com.example.workerservice.util.converter.DepartmentVoConverter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
class Tests {

    @Autowired
    private DepartmentVoConverter departmentVoConverter;

    @Autowired
    private DepartmentPoDao departmentPoDao;

    @Autowired
    private DepartmentEsPoDao departmentEsPoDao;

    @Autowired
    private DoctorRotaEsPoDao doctorRotaEsPoDao;

    @Autowired
    private DoctorRotaPoDao doctorRotaPoDao;

    @Autowired
    private PositionEsPoDao positionEsPoDao;

    @Autowired
    private PositionPoDao positionPoDao;

    @Autowired
    private WorkerInfoEsPoDao workerInfoEsPoDao;

    @Autowired
    private WorkerInfoPoDao workerInfoPoDao;

    @Test
    public void test(){



//        List<WorkerInfoPo> workerInfoPoList = workerInfoPoDao.selectByExample(new WorkerInfoPoExample());
//        for (WorkerInfoPo workerInfoPo : workerInfoPoList) {
//            WorkerInfoEsPo workerInfoEsPo = new WorkerInfoEsPo();
//            BeanUtils.copyProperties(workerInfoPo,workerInfoEsPo);
//            workerInfoEsPoDao.save(workerInfoEsPo);
//        }
//
//        List<PositionPo> positionPoList = positionPoDao.selectByExample(new PositionPoExample());
//        for (PositionPo workerInfoPo : positionPoList) {
//            PositionEsPo workerInfoEsPo = new PositionEsPo();
//            BeanUtils.copyProperties(workerInfoPo,workerInfoEsPo);
//            positionEsPoDao.save(workerInfoEsPo);
//        }

//        DepartmentPoExample departmentPoExample =new DepartmentPoExample();
//        departmentPoExample.createCriteria().andStatusEqualTo("1");
//        List<DepartmentPo> departmentPoList = departmentPoDao.selectByExample(departmentPoExample);
//        for (DepartmentPo departmentPo : departmentPoList) {
//            DepartmentEsPo departmentEsPo = new DepartmentEsPo();
//            BeanUtils.copyProperties(departmentPo,departmentEsPo);
//            departmentEsPoDao.save(departmentEsPo);
//        }

//        List<DoctorRotaPo> doctorRotaPoList = doctorRotaPoDao.selectByExample(new DoctorRotaPoExample());
//        for (DoctorRotaPo doctorRotaPo : doctorRotaPoList) {
//            DoctorRotaEsPo departmentEsPo = new DoctorRotaEsPo();
//            BeanUtils.copyProperties(doctorRotaPo,departmentEsPo);
//            doctorRotaEsPoDao.save(departmentEsPo);
//        }


    }

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
