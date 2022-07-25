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
                System.out.println("I'm walking...");
            }
        }
    }
    public static class chewGum implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 5; i++){
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
                System.out.println("I'm chewing gum...");
            }
        }
    }

  public static void main(String[] args) {
    Thread walkThread = new Thread(new Walk());
      Thread chewThread = new Thread(new chewGum());


      walkThread.setPriority(9);
      chewThread.setPriority(2);

      System.out.println("\n walkThread priority: "+ walkThread.getPriority());
      System.out.println("chewThread priority: "+ chewThread.getPriority());
      System.out.println("Main Thread priority: "+ Thread.currentThread().getPriority());

      walkThread.start();
      chewThread.start();

      System.out.println("\n walkThread ID: "+ walkThread.getId());
      System.out.println("chewThread ID: "+ chewThread.getId());
      System.out.println("Main Thread ID: "+ Thread.currentThread().getId());

      System.out.println("\n walkThread Name: "+ walkThread.getName());
      System.out.println("chewThread Name: "+ chewThread.getName());
      System.out.println("Main Thread Name: "+ Thread.currentThread().getName());

      System.out.println("\n walkThread Thread group: "+ walkThread.getThreadGroup());
      System.out.println("chewThread Thread group: "+ chewThread.getThreadGroup());
      System.out.println("Main Thread Thread group: "+ Thread.currentThread().getThreadGroup());

      System.out.println("\n walkThread priority: "+ walkThread.getPriority());
      System.out.println("chewThread priority: "+ chewThread.getPriority());
      System.out.println("Main Thread priority: "+ Thread.currentThread().getPriority());

    System.out.println("Active threads: "+Thread.activeCount());

    System.out.println("\n\n");
  }
}
