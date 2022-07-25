package concurrency;

public class ThreadLifeCycle {
    public static class Walk implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 5; i++){
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
                System.out.println("Action: I'm walking ThreadName: "+Thread.currentThread().getName()+" Thread state: "+Thread.currentThread().getState());
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
                System.out.println("I'm chewing gum "+Thread.currentThread().getName()+" Thread state: "+Thread.currentThread().getState());
            }
        }
    }
        public static void main(String[] args){
            Thread walkThread = new Thread(new Walk(), "Walk thread");
            Thread gumThread = new Thread(new ChewGum(),"Chew thread");
            System.out.println("Walk Thread state: "+walkThread.getState());
            System.out.println("Main Thread state: "+Thread.currentThread().getState());

            try{
                walkThread.start();
                System.out.println("Walk Thread state: "+walkThread.getState());
                System.out.println("Main Thread state: "+Thread.currentThread().getState());

                Thread.sleep(1000);
                walkThread.join(5000);
                System.out.println("Walk Thread state after join: "+walkThread.getState());
                System.out.println("Main Thread state after join: "+Thread.currentThread().getState());
                System.out.println("Main thread will sleep for 20s");
                Thread.sleep(20000);
                System.out.println("Walk Thread state: "+walkThread.getState());
                System.out.println("Main Thread state: "+Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}

