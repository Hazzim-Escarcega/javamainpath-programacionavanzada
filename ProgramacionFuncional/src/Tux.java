import functional.MyFunctionalInterface;

public class Tux implements MyFunctionalInterface {
    @Override
    public String doSomething(String param) {
        return "Hola soy tux y recibi este parametro: "+param;
    }
}
