package com.recruits;

public class Worker implements Runnable {
    private final Formation formation;
    private final int from;
    private final  int to;

    public Worker(Formation formation, int from, int to) {
        this.formation = formation;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        while (!formation.getStable()) {
            try {
                formation.checkFormation(from, to);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
