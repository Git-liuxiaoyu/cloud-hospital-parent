package com.example.workerservice;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/7/1
 */
public class ConsumerThread implements Runnable {

    @Override
    public void run() {

        /* 获得锁 */
        Box.LOCK.lock();

        for (Integer i = 0; i < 10; i++) {
            try {
                Box.CAN_READ.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Box.getC() != null) {
                System.out.println(Box.getC());
                Box.CAN_WRITE.signal();
            }
        }

        Box.LOCK.unlock();
    }

}
