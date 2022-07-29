package clases;

public class Main {
    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread name "+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++){
            Thread thread = new Thread(new  Task());
            thread.start();
        }
        System.out.println("Thread name "+Thread.currentThread().getName());
    }
}
