package concurrency;

public class MyThread implements Runnable {
    public MyThread() {
    }

    @Override
    public void run() {
    for (int i = 1; i <5; i++ ){
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("i: "+i+" Thread ID "+Thread.currentThread().getName());

    }
    }

  public static void main(String[] args) {

        Thread firstThread = new Thread(new MyThread(), "FirstThread");
        Thread secondThread = new Thread(new MyThread(), "SecondThread");

        secondThread.setName("2nd Thread");
        firstThread.start();
        secondThread.start();

  }
}
