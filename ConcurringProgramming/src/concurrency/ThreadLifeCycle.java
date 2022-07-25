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
                System.out.println("Action: I'm walking ...My isAlive state is: "+Thread.currentThread().isAlive());
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
    System.out.println("IsAlive state of walkThread after init " +walkThread.isAlive());

    try{
        walkThread.start();
        System.out.println("IsAlive state of walkThread after start " +walkThread.isAlive());
        walkThread.join(5000);
        System.out.println("IsAlive state of walkThread after join " +walkThread.isAlive());
        Thread.sleep(10000);
        System.out.println("IsAlive state of walkThread at the end " +walkThread.isAlive());

    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        }
}

