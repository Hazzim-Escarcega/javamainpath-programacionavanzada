package example;

import java.util.Random;
import java.util.concurrent.*;


public class Demo {
    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        //agregar task y aceptar el placeholder object para el valor de retorno
        Future<Integer> future = service.submit(new Task());

        try{
            //obtener el valor de retorno de task

            Integer result = future.get();
            System.out.println("Result from task: "+ result);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
