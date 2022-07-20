public class Main {
    public static void main(String[] args) {
        ICalculadora<String> stringCalculadora = (String mensaje) -> System.out.println(mensaje);
        stringCalculadora.mensaje("Bienvenido a Lambda");
        ICalculadora<Integer> intCalculadora = (Integer mensaje) -> System.out.println(mensaje);
        intCalculadora.mensaje(25+62+224);
    }
}
