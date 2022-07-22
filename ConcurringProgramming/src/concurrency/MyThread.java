package concurrency;

public class MyThread implements Runnable {
    @Override
    public void run() {
    System.out.println("Este bloque se ejecuto en un hilo");
    }

  public static void main(String[] args) {
    Thread myThread = new Thread (new MyThread());
    myThread.start();
  }
}
