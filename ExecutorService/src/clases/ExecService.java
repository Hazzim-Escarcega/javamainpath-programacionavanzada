package clases;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecService {
    public static class CpuIntensiveTask implements Runnable{

        @Override
        public void run() {
      System.out.println("Intensive cpu task"+Thread.currentThread().getName());
        }
    }

  public static void main(String[] args) {
    int cores = Runtime.getRuntime().availableProcessors();
      ExecutorService es = Executors.newFixedThreadPool(cores);

      for(int i = 0; i < 100; i++){
          es.execute(new CpuIntensiveTask());
      }
  }
}
