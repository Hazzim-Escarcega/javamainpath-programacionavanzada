package streams;

import empleados.Empleado;
import util.DataUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ImmutableCreator {
  public static void main(String[] args) {
    List<Empleado> empleados = DataUtils.cargarEmpleados();
    List<Empleado> empleadoImmutableList =
        empleados.stream().collect(collectingAndThen(toList(), Collections::unmodifiableList));

    Empleado empleado01 = new Empleado(1, "Hazzim", "Escarcega", "LATAM", 5000, "Mexico");
//    empleadoImmutableList.add(empleado01);
    Set<Integer> intSet = new HashSet<>();
    intSet.add(1);
    intSet.add(2);
    intSet.add(3);
    intSet.add(4);

    Set<Integer> intImmutableSet = intSet.stream().collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
intImmutableSet.add(200);
    System.out.println(empleados == empleadoImmutableList);
  }
}
