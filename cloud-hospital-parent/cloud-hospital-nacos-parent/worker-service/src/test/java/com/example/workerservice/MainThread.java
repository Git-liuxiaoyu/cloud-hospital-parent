package com.example.workerservice;

import org.junit.jupiter.api.Test;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/7/1
 */
public class MainThread {


    @Test
    public void test() throws InterruptedException {
        Thread producerThread = new Thread(new ProducerThread());
        Thread consumerThread = new Thread(new ConsumerThread());

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

    }

}
