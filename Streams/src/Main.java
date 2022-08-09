import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    vehiculos.add(new Vehiculo("1111AAA", Modelo.BMW, 10000));
    vehiculos.add(new Vehiculo("2222BBB", Modelo.AUDI, 20000));
    vehiculos.add(new Vehiculo("3333CCC", Modelo.OPEL, 30000));
    vehiculos.add(new Vehiculo("4444DDD", Modelo.BMW, 100000));
    vehiculos.add(new Vehiculo("5555EEE", Modelo.AUDI, 200000));
    vehiculos.add(new Vehiculo("6666FFF", Modelo.OPEL, 300000));
    vehiculos.add(new Vehiculo("7777GGG", Modelo.CITROEN, 0));

    /*map: Altera los elementos en base a una función y los devuelve alterados.
    También permite realizar proyecciones de atributos.*/

    List<Integer> mapResult =
        vehiculos.stream()
            .map(vehiculo -> vehiculo.getKilometros() * 2)
            .collect(Collectors.toList());
    System.out.println("\nModificacion de kilometraje results\n");
    mapResult.forEach(elemento -> System.out.println(elemento));

    List<Integer> mapResultado =
        vehiculos.stream().map(Vehiculo::getKilometros).collect(Collectors.toList());
    System.out.println("\nKilometraje inicial\n");
    mapResultado.forEach(elemento -> System.out.println(elemento));

    /*filter:  Filtra los elementos a partir del la condición de la función pasada como parámetro.*/

    List<Vehiculo> filterResult =
        vehiculos.stream()
            .filter(vehiculo -> vehiculo.getModelo().equals(Modelo.AUDI))
            .collect(Collectors.toList());
    System.out.println("\nSeleccionando todos los autos AUDI\n");
    filterResult.forEach(elemento -> System.out.println(elemento));

    /*sorted: Ordena los elementos siguiendo la condición de la función como parámetro.*/
    System.out.println("\nOrdenados por kilometraje\n");
    List<Vehiculo> sortedResult =
        vehiculos.stream()
            .sorted(Comparator.comparingInt(Vehiculo::getKilometros))
            .collect(Collectors.toList());
    sortedResult.forEach(elemento -> System.out.println(elemento));

    /*distinct: Retorna un stream con elementos no repetidos basándose en la comparación entre objetos
    con la función equals (Object.equals(object)).*/

    List<Vehiculo> distinctResult = vehiculos.stream().distinct().collect(Collectors.toList());

    System.out.println("\nSeleccion sin repetidos basandose en la comparacion de objetos\n");
    distinctResult.forEach(elemento -> System.out.println(elemento));

    List<Modelo> distinctModelo =
        vehiculos.stream().map(Vehiculo::getModelo).distinct().collect(Collectors.toList());
    System.out.println(
        "\nSeleccion sin repetidos basandose en la comparacion del modelo del vehiculo\n");
    distinctModelo.forEach(elemento -> System.out.println(elemento));

    /*peek: Esta operación no realiza cambios sobre el stream y lo devuelve tal y como entra.
    El propósito principal consiste en hacer debugging al ejecutar cualquier otra operación,
    ya que permite imprimir valores de los elementos del stream.*/

    List<String> peekResult =
        vehiculos.stream()
            .filter(v -> v.getKilometros() > 20000)
            .peek(v -> System.out.println(v))
            .map(Vehiculo::getMatricula)
            .peek(v -> System.out.println(v))
            .collect(Collectors.toList());
    System.out.println("\nSeleccion de diferentes valores usando peek\n");
    peekResult.forEach(elemento -> System.out.println(elemento));

    /*limit: Limita el número de elementos que tiene como salida el nuevo stream.*/

    List<Vehiculo> limitResult = vehiculos.stream().limit(5).collect(Collectors.toList());
    System.out.println("\nSeleccion de 5 valores usando limit\n");
    limitResult.forEach(elemento -> System.out.println(elemento));

    Predicate<Vehiculo> vehiculoPredicate = (vehiculo) -> vehiculo.getModelo() == Modelo.BMW;

    List<Vehiculo> predicateMatchResult =
        vehiculos.stream().filter(vehiculoPredicate).collect(Collectors.toList());
    System.out.println("\nFilter usando predicado\n");
    predicateMatchResult.forEach(elemento -> System.out.println(elemento));
    }
}
