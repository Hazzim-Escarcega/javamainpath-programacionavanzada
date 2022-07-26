public class ChildThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i< 4; i++){
            System.out.println("Child thread "+Thread.currentThread().getName());
            Thread.yield();
        }
    }
}
