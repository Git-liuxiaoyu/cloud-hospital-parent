package com.example.workerservice;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/7/1
 */
public class ProducerThread implements Runnable {


    @Override
    public void run() {

        /* 获得锁 */
        Box.LOCK.lock();

        /* 生产 */
        for (Integer i = 0; i < 10; i++) {

            if (Box.getC() == null) {
                Box.setC(i);
                try {
                    Box.CAN_WRITE.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Box.CAN_READ.signal();
        }

        Box.LOCK.unlock();
    }


}
