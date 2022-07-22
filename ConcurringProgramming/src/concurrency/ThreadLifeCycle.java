package concurrency;

public class ThreadLifeCycle {
    public static class Walk implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 5; i++){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
                System.out.println("I'm walking "+Thread.currentThread().getName());
            }
        }
    }
    public static class ChewGum implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 5; i++){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
                System.out.println("I'm chewing gum "+Thread.currentThread().getName());
            }
        }
    }
        public static void main(String[] args){
            Thread walkThread = new Thread(new Walk(), "Walk thread");
            Thread gumThread = new Thread(new ChewGum(),"Chew thread");

            try{
                walkThread.start();
                walkThread.join(1000);
                gumThread.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}

