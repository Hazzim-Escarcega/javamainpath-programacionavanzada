import jdk.jshell.spi.ExecutionControl;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class Ejemplos {
    public static void main(String[] args) {
        //actionListenerExample();
        //callableExample();
        //runnableExample();
        comparableExample();
    }

    public static void actionListenerExample(){
        var frame = new Frame();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        var btn = new JButton("Exit");
        btn.setSize(frame.getSize());
        btn.addActionListener(event ->
        {
            System.out.println("Saliendo");
            System.exit(0);
        });
        frame.add(btn);
        frame.setVisible(true);
    }
    public static void callableExample(){
        try {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> future = executor.submit(Ejemplos::operation);
            System.out.println("Resutado "+future.get());
            executor.shutdown();

        }catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    public static void comparableExample(){
        var tree = new TreeSet<>(Ejemplos::compare);
        tree.add(4);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.add(8);
        tree.add(1);
        tree.forEach(System.out::println);
    }
    private static int compare(Integer a, Integer b){
        if (a<b){
            return 1;
        }
        if (a==b){
            return 0;
        }
        return -1;
    }
    public static void runnableExample(){
        var thread = new Thread(Ejemplos::runBehavior);
        thread.start();
    }
    private static void runBehavior(){
        var i = 0;
        while (i++ != 100){
            System.out.println("Llamada a run() #"+i);

        }
    }
    private static String operation(){
        Character[] charArray = new Character[]{'S','o', 'y',' ', 'u','n', 'a', ' ', 'c','a', 'd', 'e', 'n', 'a'};
        var buffer = new StringBuffer("Recomponiendo Cadena -> ");

        Arrays.stream(charArray).forEach(character -> {
            System.out.println(character);
            buffer.append(character);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(Thread.currentThread().getName());
        return buffer.toString();
    }
}

