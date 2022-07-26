package util;

import empleados.Empleado;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    public static List<Empleado> cargarEmpleados(){
        List<Empleado> listaEmpleado = new ArrayList<>();
        Empleado empleado01 = new Empleado(1, "Hazzim", "Escarcega", "LATAM", 5000, "Mexico");
        Empleado empleado02 = new Empleado(1, "Pedro", "Perez", "EUROPA", 5000, "Alemania");
        Empleado empleado03 = new Empleado(1, "Luis", "Martinez", "AFRICA", 5000, "Nigeria");
        Empleado empleado04 = new Empleado(1, "Jose", "Rodriguez", "APAC", 5000, "Estados Unidos");
        Empleado empleado05 = new Empleado(1, "Gerardo", "Mata", "NORTE AMERICA", 5000, "Brasil");
        Empleado empleado06 = new Empleado(1, "Romina", "Trevizo", "EUROPA", 5000, "Francia");
        Empleado empleado07 = new Empleado(1, "Esther", "Montes", "LATAM", 5000, "Argentina");
        Empleado empleado08 = new Empleado(1, "Juan", "Garcia", "AFRICA", 5000, "Sudafrica");

        listaEmpleado.add(empleado01);
        listaEmpleado.add(empleado02);
        listaEmpleado.add(empleado03);
        listaEmpleado.add(empleado04);
        listaEmpleado.add(empleado05);
        listaEmpleado.add(empleado06);
        listaEmpleado.add(empleado07);
        listaEmpleado.add(empleado06);

        return listaEmpleado;

    }
}
