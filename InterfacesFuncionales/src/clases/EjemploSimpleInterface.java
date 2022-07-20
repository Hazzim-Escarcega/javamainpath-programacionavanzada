package clases;

import interfaces.SimpleInterface;

public class EjemploSimpleInterface {
    public static void main(String[] args) {
        SimpleInterface obj = () -> System.out.println("Dentro de la interfaz");

        obj.procesar();
    }
}
