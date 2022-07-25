package concurrency;

public class ThreadMethods {
    public static class Walk implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 5; i++){
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
                String threadGroup = Thread.currentThread().getThreadGroup().getName();
                int active = Thread.activeCount();
                System.out.println("Action: I'm walking...\nMy Group "+threadGroup+"\n Has an active count of "+active);
            }
        }
    }
    public static class ChewGum implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 5; i++){
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
                String threadGroup = Thread.currentThread().getThreadGroup().getName();
                int active = Thread.activeCount();
                System.out.println("Action: I'm chewing gum...\nMy Group "+threadGroup+"\n Has an active count of "+active);
            }
        }
    }

  public static void main(String[] args) {
    ThreadGroup groupOne = new ThreadGroup("GroupOne");
      ThreadGroup groupTwo = new ThreadGroup("GroupTwo");

      Thread walkThreadOne = new Thread(groupOne, new Walk());
      Thread walkThreadTwo = new Thread(groupTwo, new Walk());
      Thread walkThreadThree = new Thread(groupTwo, new Walk());

      Thread chewThreadOne = new Thread(groupOne, new ChewGum());
      Thread chewThreadTwo = new Thread(groupTwo, new ChewGum());

      walkThreadOne.start();
      walkThreadTwo.start();
      walkThreadThree.start();
      chewThreadOne.start();
      chewThreadTwo.start();

    System.out.println("Active threads for main "+Thread.activeCount());
      System.out.println("Active threads for G1 "+groupOne.activeCount());
      System.out.println("Active threads for G2 "+groupTwo.activeCount());
  }
}
