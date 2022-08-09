import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();

        Persona persona1 = new Persona("Hazzim", 30);
        Persona persona2 = new Persona("Pedro", 28);
        Persona persona3 = new Persona("Luis", 27);
        Persona persona4 = new Persona("Jose", 26);
        Persona persona5 = new Persona("Edgar", 25);

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        personas.add(persona5);

        Predicate<Persona> predicate = (cualquierObjeto) -> cualquierObjeto.edad >= 27;



        List<Persona> personasFiltradas = personas.stream().filter(predicate).toList();

        Consumer<Persona> action = (persona) -> System.out.println(persona.nombre);

        personasFiltradas.forEach(action);

    }
}
