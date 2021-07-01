package com.example.workerservice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/7/1
 */
public class Box {

    public static Lock LOCK;
    public static Condition CAN_WRITE;
    public static Condition CAN_READ;
    private static Integer box;

    static {
        LOCK = new ReentrantLock();
        CAN_WRITE = LOCK.newCondition();
        CAN_READ = LOCK.newCondition();
    }

    public static Integer getC() {
        return box;
    }

    public static void setC(Integer c) {
        box = c;
    }
}
