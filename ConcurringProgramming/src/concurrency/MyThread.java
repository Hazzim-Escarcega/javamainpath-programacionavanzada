package concurrency;

public class MyThread implements Runnable {
    public MyThread() {
    }

    @Override
    public void run() {
    for (int i = 0; i <5; i++ ){
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("i: "+i);
    }
    }

  public static void main(String[] args) {

        Thread myThread = new Thread(new MyThread());
        myThread.start();
  }
}
