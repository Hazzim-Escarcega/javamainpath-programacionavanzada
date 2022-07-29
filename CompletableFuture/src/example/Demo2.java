package example;

import java.util.concurrent.CompletableFuture;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting process...");
        CompletableFuture.runAsync(() -> longNetworProcess(5))
                .thenAccept(value -> System.out.println("completed "+ value));
        System.out.println("Process called");
        System.out.println("sleeping for a little");
        sleepALittle();
        System.out.println("Done sleeping");

    }
    public static int longNetworProcess(int value){
        sleepALittle();
        return value * 10;
    }
    public static void sleepALittle(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
