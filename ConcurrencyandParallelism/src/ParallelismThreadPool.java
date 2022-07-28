import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelismThreadPool {
    public static Runnable processTax(String user){
        System.out.println("Taxes for user: "+user+" "+Thread.currentThread().getName());
        return null;
    }
    public static void heavyCalculations(Double amount){
        Math.sqrt(amount);
        System.out.println("Tax amount equals to: "+amount+" "+ Thread.currentThread().getName());
    }

  public static void main(String[] args) {
      ExecutorService es = Executors.newFixedThreadPool(4);
      es.submit(() -> processTax("Jacinto" ));
      es.submit(() -> processTax("Pedro"));
      es.submit(() -> heavyCalculations(7414.23));


  }
}
