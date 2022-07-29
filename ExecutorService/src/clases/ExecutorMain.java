package clases;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {
    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread name "+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++){
           es.execute(new Task());


        }
        System.out.println("Thread name "+Thread.currentThread().getName());
    }
}
