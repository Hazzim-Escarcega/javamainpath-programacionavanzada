package clases;

import interfaces.Calcular;

public class EjemploInterfazCalcular{
    public static void main(String[] args) {
        Calcular<Integer> integerObj = (n1, n2) -> System.out.println(n1+n2);
        Calcular<Double>  doubleObj = (n1, n2) -> System.out.println(n1+n2);
        integerObj.calcular(23,4);
        doubleObj.calcular(.5, 7.939);
    }


}
