package com.univ.labs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WorkerThread extends Thread {
    volatile FieldModel fieldModel;
    CyclicBarrier barrier;
    ReentrantReadWriteLock lock;
    int types;
    int start;
    int finish;

    WorkerThread(FieldModel fieldModel, CyclicBarrier barrier, ReentrantReadWriteLock lock, int start, int finish, int types){
        this.fieldModel = fieldModel;
        this.barrier = barrier;
        this.lock = lock;
        this.types = types;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            lock.readLock().lock();
            fieldModel.simulate(types, start, finish);
            lock.readLock().unlock();
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException ignored) {
            }
        }
    }
}
