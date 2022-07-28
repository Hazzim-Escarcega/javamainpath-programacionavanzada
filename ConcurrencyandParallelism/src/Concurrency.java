import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrency {
    static int availableTickets = 2;

    public static void bookticket(String clientName){

    System.out.println("Ticket booked to "+clientName+" "+Thread.currentThread().getName());
        availableTickets--;
        System.out.println("Tickets left "+availableTickets+ " "+Thread.currentThread().getName());

    }

  public static void main(String[] args) {
      ReentrantLock l = new ReentrantLock();
    new Thread(()->{
        l.lock();
        if(availableTickets>0){
            bookticket("Hazzim");
        }
        l.unlock();
    }).start();
      new Thread(()->{
          l.lock();
          if(availableTickets>0){
              bookticket("Pepe");
          }
          l.unlock();
      }).start();
  }
}
