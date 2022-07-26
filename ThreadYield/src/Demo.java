public class Demo {
    public static void main(String[] args) {
        ChildThread t1 = new ChildThread();
        t1.start();

        for (int i = 0; i < 3; i++){
            System.out.println("Main thread "+Thread.currentThread().getName());
        }
    }
}
